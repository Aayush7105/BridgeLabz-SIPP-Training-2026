const mongoose = require('mongoose');

const userSchema = new mongoose.Schema({
    username: String,
    email: String,
    loginTimes: [Date],
    logoutTimes: [Date],
    lastActiveAt: Date
});

userSchema.methods.recordLogin = function () {
    const now = new Date();
    this.loginTimes.push(now);
    this.lastActiveAt = now;
    return this.save();
};

userSchema.methods.recordLogout = function () {
    const now = new Date();
    this.logoutTimes.push(now);
    this.lastActiveAt = now;
    return this.save();
};

userSchema.pre('save', function (next) {
    this.lastActiveAt = new Date();
    next();
});

userSchema.pre(['updateOne', 'findOneAndUpdate', 'updateMany'], function (next) {
    this.set({ lastActiveAt: new Date() });
    next();
});

const User = mongoose.model('User', userSchema);

module.exports = { userSchema, User };
