CREATE TABLE sports_inventory (
                                  id SERIAL PRIMARY KEY,
                                  name VARCHAR(100) NOT NULL,
                                  parameters TEXT,
                                  age_limit INT,
                                  placement_conditions TEXT
);
