create database J205_Harivardani_InsuranceManagementSystem;
use J205_Harivardani_InsuranceManagementSystem;

CREATE TABLE User (
    userId INT PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(50)
);
INSERT INTO User (userId, username, password, role)
VALUES
    (1, 'hari', 'hari123', 'admin'),
    (2, 'nithi', 'abc123', 'user'),
    (3, 'Anu', 'pass456', 'user'),
    (4, 'Ram', 'ram@789', 'admin'),
    (5, 'santhosh', 'mike123', 'user');


CREATE TABLE Client (
    clientId INT PRIMARY KEY,
    clientName VARCHAR(255),
    contactInfo VARCHAR(255),
    policy VARCHAR(50) 
);

INSERT INTO Client (clientId, clientName, contactInfo, policy)
VALUES
    (1, 'ICICI Bank', '9568741258', 'Health Insurance'),
    (2, 'Axis Bank', '8956741255', 'Life policy'),
    (3, 'Bajaj', '9865751485', 'Star policy'),
    (4, 'Indian Overseas ', '6789545632', 'neo policy'),
    (5, 'SBI ', '9658745699', 'education policy');

CREATE TABLE Claim (
    claimId INT PRIMARY KEY,
    claimNumber VARCHAR(100),
    dateFiled DATE,
    claimAmount DECIMAL(10, 2),
    status VARCHAR(50),
    policy VARCHAR(50), 
    client INT, 
    FOREIGN KEY (client) REFERENCES Client(clientId)
);

INSERT INTO Claim (claimId, claimNumber, dateFiled, claimAmount, status, policy, client)
VALUES
    (1, 'CLM001', '2023-01-15', 500.00, 'Pending', 'Health Insurance', 1),
    (2, 'CLM002', '2023-02-20', 1000.00, 'Approved', 'Life policy', 2),
    (3, 'CLM003', '2023-03-25', 750.00, 'Pending', 'Star policy', 3),
    (4, 'CLM004', '2023-04-30', 2000.00, 'Approved', 'neo policy', 4),
    (5, 'CLM005', '2023-05-10', 1500.00, 'Pending', 'education policy', 5);

CREATE TABLE Payment (
    paymentId INT PRIMARY KEY,
    paymentDate DATE,
    paymentAmount DECIMAL(10, 2),
    client INT, 
    FOREIGN KEY (client) REFERENCES Client(clientId)
);

INSERT INTO Payment (paymentId, paymentDate, paymentAmount, client)
VALUES
    (1, '2023-02-01', 200.00, 1),
    (2, '2023-03-10', 300.00, 2),
    (3, '2023-04-15', 400.00, 3),
    (4, '2023-05-20', 500.00, 4),
    (5, '2023-06-25', 600.00, 5);

CREATE TABLE Policy (
    policyId INT PRIMARY KEY,
    userId INT,
    clientId INT,
    claimId INT,
    policyName VARCHAR(255),
    paymentId INT,
    policyPremium DECIMAL(10, 2)
);

select * from policy;
