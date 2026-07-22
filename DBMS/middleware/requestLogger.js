const fs = require('fs');
const path = require('path');

const logFilePath = path.join(__dirname, 'requests.log');

const requestLogger = (req, res, next) => {
    const startTime = Date.now();
    const timestamp = new Date().toISOString();

    res.on('finish', () => {
        const responseTime = Date.now() - startTime;
        const logEntry = `[${timestamp}] ${req.method} ${req.originalUrl || req.url} ${res.statusCode} - ${responseTime}ms\n`;

        fs.appendFile(logFilePath, logEntry, (err) => {
            if (err) {
                console.error('Failed to write request log:', err);
            }
        });
    });

    next();
};

module.exports = requestLogger;
