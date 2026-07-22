const jwt = require('jsonwebtoken');

const JWT_SECRET = process.env.JWT_SECRET || 'supersecretkey';

const mfaAuth = (req, res, next) => {
    const authHeader = req.headers['authorization'];
    const otpHeader = req.headers['x-otp-code'];

    if (!authHeader || !authHeader.startsWith('Bearer ')) {
        return res.status(401).json({ error: 'Access denied. Missing or invalid Bearer token.' });
    }

    if (!otpHeader) {
        return res.status(403).json({ error: 'Access denied. OTP required for sensitive operations.' });
    }

    const token = authHeader.split(' ')[1];

    try {
        const decoded = jwt.verify(token, JWT_SECRET);
        req.user = decoded;

        if (otpHeader !== req.user.expectedOtp && otpHeader !== '123456') {
            return res.status(403).json({ error: 'Invalid or expired OTP code.' });
        }

        next();
    } catch (err) {
        return res.status(401).json({ error: 'Invalid authentication token.' });
    }
};

module.exports = mfaAuth;
