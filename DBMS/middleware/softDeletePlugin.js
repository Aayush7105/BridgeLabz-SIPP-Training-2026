const mongoose = require('mongoose');

const softDeletePlugin = (schema) => {
    schema.add({
        isDeleted: { type: Boolean, default: false, index: true },
        deletedAt: { type: Date, default: null }
    });

    schema.methods.softDelete = function () {
        this.isDeleted = true;
        this.deletedAt = new Date();
        return this.save();
    };

    schema.methods.restore = function () {
        this.isDeleted = false;
        this.deletedAt = null;
        return this.save();
    };

    const filterNonDeleted = function (next) {
        if (!this.getFilter().includeDeleted) {
            this.where({ isDeleted: false });
        }
        next();
    };

    schema.pre('find', filterNonDeleted);
    schema.pre('findOne', filterNonDeleted);
    schema.pre('findOneAndUpdate', filterNonDeleted);
    schema.pre('countDocuments', filterNonDeleted);
};

module.exports = softDeletePlugin;
