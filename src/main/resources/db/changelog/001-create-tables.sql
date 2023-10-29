CREATE TABLE IF NOT EXISTS person
(
    id
    serial
    PRIMARY
    KEY,
    name
    VARCHAR
(
    255
) NOT NULL,
    gender VARCHAR
(
    10
),
    date_of_birth DATE,
    address TEXT,
    phone VARCHAR
(
    15
)
    );
-- Create the 'client' table
CREATE TABLE IF NOT EXISTS client
(
    id SERIAL PRIMARY KEY REFERENCES person
(
    id
) ON DELETE NO ACTION,
    password VARCHAR
(
    255
) NOT NULL,
    state VARCHAR
(
    50
)
    );

-- Create the 'account' table
CREATE TABLE IF NOT EXISTS account
(
    number_account
    SERIAL
    PRIMARY
    KEY,
    balance
    BIGINT
    NOT
    NULL,
    state
    BOOLEAN,
    type
    VARCHAR
(
    50
),
    client_id SERIAL,
    FOREIGN KEY
(
    client_id
) REFERENCES client
(
    id
)
    );

-- Create the 'transactions' table
CREATE TABLE IF NOT EXISTS transactions
(
    transaction_id
    SERIAL
    PRIMARY
    KEY,
    date
    TIMESTAMP
    NOT
    NULL,
    type
    VARCHAR
(
    50
),
    state BOOLEAN,
    balance_initial BIGINT NOT NULL,
    balance_transaction BIGINT NOT NULL,
    movement VARCHAR
(
    50
) NOT NULL,
    client_id SERIAL,
    number_account SERIAL,
    FOREIGN KEY
(
    client_id
) REFERENCES client
(
    id
),
    FOREIGN KEY
(
    number_account
) REFERENCES account
(
    number_account
)
    );