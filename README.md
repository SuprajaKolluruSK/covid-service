# covid-service

Covid-service is an maven project.It returns correlation coefficient between the percentage of people that died and got vaccinated of COVID-19 given a continent.

Formula of correlation coefficient 

<img width="312" alt="image" src="https://user-images.githubusercontent.com/95203590/158044883-90992c03-f81f-40cd-add3-9ae8a8790bc7.png">

Here X reprsents the  percentage of death of a given country in a continent
 and Y reprsents percentage of vaccinated of a given country in a continent

Steps to run the project

1.Use mvn clean install to build the project

2.Import the project in a IDE and the give the run configuration as follows

<img width="837" alt="image" src="https://user-images.githubusercontent.com/95203590/158044955-29deb350-0aa4-4b59-9aff-0c2e2542a6f8.png">

API src?continent={continent}

It returns the correlation coefficient of a continent.


<img width="602" alt="image" src="https://user-images.githubusercontent.com/95203590/158051509-44e66422-121e-466c-8349-27fecf1f6ecd.png">

