const sanitizeValue = (value) => {
    if (typeof value === 'string') {
        let sanitized = value
            .replace(/</g, '&lt;')
            .replace(/>/g, '&gt;')
            .replace(/&/g, '&amp;')
            .replace(/"/g, '&quot;')
            .replace(/'/g, '&#x27;')
            .replace(/\//g, '&#x2F;');

        sanitized = sanitized.replace(/(\b(SELECT|INSERT|UPDATE|DELETE|DROP|ALTER|EXEC|UNION|CREATE|TRUNCATE)\b|--|;)/gi, '');

        return sanitized.trim();
    } else if (typeof value === 'object' && value !== null) {
        Object.keys(value).forEach((key) => {
            if (key.startsWith('$') || key.includes('.')) {
                delete value[key];
            } else {
                value[key] = sanitizeValue(value[key]);
            }
        });
    }
    return value;
};

const sanitizeInput = (req, res, next) => {
    if (req.body) req.body = sanitizeValue(req.body);
    if (req.query) req.query = sanitizeValue(req.query);
    if (req.params) req.params = sanitizeValue(req.params);
    next();
};

module.exports = sanitizeInput;
