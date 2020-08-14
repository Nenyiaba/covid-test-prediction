#SET TO READ COMMAND LINE ARGUMENT
test_string = commandArgs(trailingOnly=TRUE)

#sprintf("Java---%s", test_string[1])

#SPLIT THE COMMAND LINE ARGUMENT WITH COMMAS INTO AN ARRAY
test <- strsplit(test_string, ",")

#CONVERT THE TEST ARRAY TO NUMERIC ARRAY
test <- as.numeric(unlist(test))

#CONVERT THE NUMERIC TEST ARRAY TO A DATAFRAME WHICH CAB BE PASSED AS TEST ARGUMENT TO KNN
test_data <- data.frame(test[1], test[2], test[3], test[4], test[5], test[6],
                        test[7], test[8], test[9], test[10])

library(gmodels)
library(class)

#READ THE FILE CONTAINING DATA
covid_data <- read.csv("covid-19.csv")

#MAKE THE ADVICE COLUMN A FACTOR
covid_data[,11] <- factor(covid_data[,11])

#RANDOMIZE THE DATASET
set.seed(1)
covid_data_rand <- covid_data[order(runif(650)), ]

#REMOVE THE FACTOR COLUMN
covid_data_z <- covid_data_rand[-11]

#SPLIT DATA INTO TRAINING AND TEST
#Training Data - 80%
covid_data_train <- covid_data_z[1:450, ]

#Test Data - 20%
covid_data_test  <- covid_data_z[451:650, ]

#CREATE LABELS FOR TRAINING AND TEST DATA
covid_data_train_labels <- covid_data_rand[1:450, 11]
covid_data_test_labels <- covid_data_rand[451:650, 11]

#PREDICTIONS
predictions <- knn(train = covid_data_train, test = covid_data_test,
                   cl = covid_data_train_labels, k=20)

#COMPARE PREDICTED VALUES WITH ACTUAL VALUES
CrossTable(predictions, covid_data_test_labels,
           prop.chisq = FALSE, prop.c = FALSE, prop.r = FALSE)

argument_prediction <- knn(train = covid_data_train, test = test_data,
                   cl = covid_data_train_labels, k=20)

sprintf("PREDICTION RESULT===%s",as.integer(argument_prediction))
#sprintf("Java---%s", test[1])
