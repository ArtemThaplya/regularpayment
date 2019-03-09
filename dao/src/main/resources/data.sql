INSERT INTO payments (fullName, INN, cardNumber, beneficiarysCurrentAccount, MFO, OKPO, recipientsName, retirementPeriod, amountOfPayment)
VALUES ('Tsaplya Artem Nikolaevich', '1234567890', '1234567890', '12304567890', '123456', '123456', 'pay',
        '2019-04-05', '3000.45');

INSERT INTO payments (fullName, INN, cardNumber, beneficiarysCurrentAccount, MFO, OKPO, recipientsName, retirementPeriod, amountOfPayment)
VALUES ('Tsaplya Valeriya Nikolaevna', '1098765432', '654321098', '1987654321', '654321', '654321', 'pay',
        '2019-04-09', '5000.99');

INSERT INTO entries (idInstructionRegularPayment, dateAndTime, amountOfPayment, status)
VALUES ('4', '2019-03-11', '7000.48', 'Active');

