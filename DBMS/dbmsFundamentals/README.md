# DBMS & MongoDB Fundamentals Guide

## Module 1: Introduction to Databases

### What is a Database?
A database is an organized collection of structured information or data, typically stored electronically in a computer system. Databases are managed by Database Management Systems (DBMS), which provide interfaces for users and applications to interact with the data.

### Key Characteristics
- **Organized Storage:** Data is stored in a structured format.
- **Efficient Retrieval:** Quick access to specific information.
- **Data Integrity:** Maintains accuracy and consistency.
- **Concurrent Access:** Multiple users can access simultaneously.
- **Security:** Controls who can access and modify data.

### Types of Database Systems
Databases are broadly categorized into two main types:
1. **Relational Databases (SQL):** Store data in tables with predefined schemas.
2. **Non-Relational Databases (NoSQL):** Store data in flexible, schema-less formats.

---

## Module 2: SQL vs NoSQL Overview

### SQL Databases (Relational)
SQL (Structured Query Language) databases organize data into tables with rows and columns, following a rigid schema.

#### Characteristics
- **Structured Schema:** Tables with predefined columns and data types.
- **ACID Compliance:** Ensures reliable transactions:
  - **Atomicity:** All operations succeed or fail together.
  - **Consistency:** Data remains valid after transactions.
  - **Isolation:** Concurrent transactions don’t interfere.
  - **Durability:** Committed data persists even after failures.
- **Relationships:** Tables connected through foreign keys.
- **Vertical Scaling:** Typically scaled by upgrading hardware (RAM, CPU).

#### Popular SQL Databases
- MySQL
- PostgreSQL
- Oracle Database
- Microsoft SQL Server
- SQLite

#### Use Cases
- Financial systems requiring strict consistency
- E-commerce applications with complex transactions
- Enterprise resource planning (ERP) systems
- Applications requiring complex joins and queries

#### Example SQL Table Structure
```sql
-- Users Table
CREATE TABLE users (
    user_id INT PRIMARY KEY,
    username VARCHAR(50),
    email VARCHAR(100),
    created_at TIMESTAMP
);

-- Orders Table
CREATE TABLE orders (
    order_id INT PRIMARY KEY,
    user_id INT,
    total_amount DECIMAL(10,2),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);
```

---

### NoSQL Databases (Non-Relational)
NoSQL databases provide flexible, schema-less data storage optimized for specific use cases.

#### Characteristics
- **Flexible Schema:** Can store data without predefined structure.
- **BASE Properties:**
  - **Basically Available:** System guarantees availability.
  - **Soft State:** State may change over time.
  - **Eventually Consistent:** System becomes consistent over time.
- **Horizontal Scaling:** Easily distributed across multiple servers.
- **High Performance:** Optimized for specific operations.

#### Types of NoSQL Databases
1. **Document Stores (MongoDB, CouchDB):** Store data as documents (JSON, BSON, XML) with flexible schemas per document.
2. **Key-Value Stores (Redis, DynamoDB):** Simple key-value pairs with extremely fast lookups.
3. **Column-Family Stores (Cassandra, HBase):** Data stored in columns rather than rows, optimized for large-scale analytics.
4. **Graph Databases (Neo4j, ArangoDB):** Store data as nodes and relationships, ideal for connected data.

#### Use Cases
- Real-time web applications
- Content management systems
- Big data analytics
- IoT sensor data storage
- Social networks with complex relationships
- Caching layers

---

### SQL vs NoSQL Comparison

| Feature | SQL Databases | NoSQL Databases |
|---|---|---|
| **Data Model** | Relational (Tables, Rows, Columns) | Non-Relational (Documents, Key-Value, Graphs) |
| **Schema** | Rigid / Predefined | Flexible / Dynamic |
| **Scaling** | Vertical (Scale-up) | Horizontal (Scale-out) |
| **ACID / BASE** | ACID Guarantees | BASE Properties |
| **Transactions** | Complex multi-table transactions | Atomic at document/key level |
| **Query Language** | Structured Query Language (SQL) | Database-specific API / Query Language |

---

## Module 3: Choosing Databases Using CAP & PACELC Theorems

### Understanding CAP Theorem
The CAP theorem, proposed by Eric Brewer, states that a distributed database system can only guarantee two out of three properties simultaneously:

1. **C - Consistency:** Every read receives the most recent write or an error. All nodes see the same data at the same time. *(Example: Bank account balance across ATMs)*
2. **A - Availability:** Every request receives a response (success or failure). System remains operational even if some nodes fail. *(Example: Website remaining accessible)*
3. **P - Partition Tolerance:** System continues operating despite network failures or communication breakdowns between nodes. *(Example: Multi-datacenter network drops)*

```
                   CAP Theorem
                   /    |    \
                  /     |     \
                 C      A      P
                 \     / \     /
                  \   /   \   /
                   CA   CP   AP
```

### CAP Combinations
Since network partitions are inevitable in distributed systems, distributed databases must choose between Consistency and Availability:

- **CA (Consistency + Availability):** Cannot handle network partitions. Used in traditional single-server RDBMS (e.g., single-node MySQL/PostgreSQL).
- **CP (Consistency + Partition Tolerance):** System may become unavailable during network partitions to prevent stale reads/writes (e.g., MongoDB, HBase, Redis).
- **AP (Availability + Partition Tolerance):** System remains available during partitions, returning potentially stale data (e.g., Cassandra, DynamoDB, CouchDB).

---

### Decision Framework for Database Selection

#### Choose CP Databases When:
- Data accuracy is critical (financial systems, booking systems).
- Temporary unavailability is acceptable over showing wrong data.
- Strong consistency requirements exist.

#### Choose AP Databases When:
- System must always be available (social media feeds, content delivery).
- Eventual consistency is acceptable.
- High write throughput is needed.

---

### Real-World Examples
- **Banking System (CP - MongoDB/SQL):** Money transfers require absolute consistency.
- **Social Media Feed (AP - Cassandra):** Posts can appear a few seconds late, but feed must never down.
- **E-commerce Inventory (CP - MongoDB):** Stock management must prevent overselling items.

---

### Extended Considerations: PACELC Theorem
PACELC extends CAP by stating:
- **If there is a Partition (PAC):** Trade off **Availability** vs **Consistency**.
- **Else under normal operation (ELC):** Trade off **Latency** vs **Consistency**.

---

## Module 4: MongoDB Basics

### What is MongoDB?
MongoDB is a document-oriented NoSQL database that stores data in flexible, JSON-like documents. It is designed for scalability, high performance, and ease of development.

### Core Concepts
- **Database:** A container for collections.
- **Collection:** A group of MongoDB documents (equivalent to an SQL table).
- **Document:** A single record in a collection stored as BSON (equivalent to an SQL row).
- **Field:** A key-value pair within a document (equivalent to an SQL column).

```json
// Database: university
// Collection: students
{
  "_id": ObjectId("507f1f77bcf86cd799439011"),
  "name": "Alice Johnson",
  "age": 21,
  "email": "alice@university.edu",
  "courses": ["CS101", "CS202", "MATH301"],
  "address": {
    "street": "123 Main St",
    "city": "Boston",
    "state": "MA"
  },
  "gpa": 3.8,
  "enrolled": true
}
```

---

### Basic CRUD Operations

#### Create (Insert)
```javascript
// Insert single document
db.students.insertOne({
  name: "Bob Smith",
  age: 22,
  email: "bob@university.edu",
  courses: ["CS101", "PHYS201"]
});

// Insert multiple documents
db.students.insertMany([
  { name: "Carol White", age: 20, courses: ["CS101"] },
  { name: "David Brown", age: 23, courses: ["CS202", "MATH301"] }
]);
```

#### Read (Query)
```javascript
// Find all documents
db.students.find();

// Find with condition
db.students.find({ age: { $gte: 21 } });

// Find one document
db.students.findOne({ name: "Alice Johnson" });

// Find with multiple conditions
db.students.find({
  age: { $gte: 20 },
  enrolled: true
});

// Projection (select specific fields)
db.students.find(
  { age: { $gte: 21 } },
  { name: 1, email: 1, _id: 0 }
);
```

#### Update
```javascript
// Update single document
db.students.updateOne(
  { name: "Bob Smith" },
  { $set: { age: 23, gpa: 3.5 } }
);

// Update multiple documents
db.students.updateMany(
  { age: { $lt: 21 } },
  { $set: { status: "freshman" } }
);

// Add to array
db.students.updateOne(
  { name: "Alice Johnson" },
  { $push: { courses: "CS303" } }
);

// Remove from array
db.students.updateOne(
  { name: "Alice Johnson" },
  { $pull: { courses: "CS101" } }
);
```

#### Delete
```javascript
// Delete single document
db.students.deleteOne({ name: "Bob Smith" });

// Delete multiple documents
db.students.deleteMany({ age: { $lt: 18 } });

// Delete all documents in collection
db.students.deleteMany({});
```

---

### Query Operators

#### Comparison Operators
- `$eq`: Equal to
- `$ne`: Not equal to
- `$gt`: Greater than
- `$gte`: Greater than or equal
- `$lt`: Less than
- `$lte`: Less than or equal
- `$in`: Match any value in array
- `$nin`: Match none of values in array

#### Logical Operators
```javascript
// AND
db.students.find({
  $and: [
    { age: { $gte: 21 } },
    { gpa: { $gte: 3.5 } }
  ]
});

// OR
db.students.find({
  $or: [
    { age: { $lt: 20 } },
    { gpa: { $gte: 3.8 } }
  ]
});

// NOT
db.students.find({
  age: { $not: { $gte: 21 } }
});
```

---

### Indexing in MongoDB
Indexes improve query performance by reducing the number of documents inspected.

```javascript
// Create index (1 for ascending, -1 for descending)
db.students.createIndex({ email: 1 });

// Create compound index
db.students.createIndex({ name: 1, age: -1 });

// Create unique index
db.students.createIndex({ email: 1 }, { unique: true });

// View indexes
db.students.getIndexes();

// Drop index
db.students.dropIndex("email_1");
```

---

### Aggregation Framework
```javascript
// Calculate average GPA
db.students.aggregate([
  { $group: { _id: null, avgGPA: { $avg: "$gpa" } } }
]);

// Count students by age
db.students.aggregate([
  { $group: { _id: "$age", count: { $sum: 1 } } },
  { $sort: { _id: 1 } }
]);

// Filter, project, and sort
db.students.aggregate([
  { $match: { age: { $gte: 21 } } },
  { $project: { name: 1, email: 1, gpa: 1 } },
  { $sort: { gpa: -1 } }
]);
```

---

## Module 5: JSON vs BSON

### JSON (JavaScript Object Notation)
JSON is a lightweight, human-readable text format for data interchange.

#### Characteristics
- Text-based and human-readable.
- Language-independent.
- Basic Data Types: String, Number, Boolean, Array, Object, null.

#### Limitations
- No native Date/Time type (stored as formatted strings).
- No binary data type.
- Floating-point precision limitations.
- Slower parsing speed compared to binary formats.

---

### BSON (Binary JSON)
BSON is a binary-encoded serialization of JSON-like documents designed specifically for MongoDB.

#### Additional BSON Data Types
- **Date:** Native UTC datetime objects.
- **BinData:** Binary data storage (files, images).
- **ObjectId:** 12-byte unique identifier.
- **Decimal128:** High-precision decimal for financial data.
- **NumberInt / NumberLong:** 32-bit and 64-bit explicit integer types.
- **Timestamp:** Internal MongoDB replication timestamp.

---

### JSON vs BSON Comparison

| Feature | JSON | BSON |
|---|---|---|
| **Format** | Text-based | Binary-encoded |
| **Readability** | Human-readable | Machine-optimized |
| **Data Types** | Basic (6 types) | Rich (Includes Date, BinData, ObjectId, Decimal128) |
| **Parsing Speed** | Slower (requires text parsing) | Fast (uses length-prefixed fields) |
| **Storage Efficiency** | Higher text overhead | Optimized binary layout |

---

### Conversion Flow & Best Practices
```
[Client Application]  <--- JSON (HTTP Request/Response) --->  [MongoDB Driver]  <--- BSON (Binary Storage) --->  [MongoDB Engine]
```

- **Use JSON for:** APIs, web communication, human-readable configs, and logs.
- **Use BSON for:** High-performance database storage, precise financial calculations (`Decimal128`), native date arithmetic, and binary payloads.
