# Money-Withdraw-Workflow
Money withdraw workflow using spring boot and eureka server

## Workflow Starter, Workflow Worker and Activity Worker all are registered on eureka server registry and they are communicating with each other using REST API.
![alt text](https://github.com/Nice-Internship-2022-23/Money-Withdraw-Workflow/blob/main/money_withdrawal_spring.drawio.png?row=true)

## Workflow starts from workflow starter, workflow worker decides which activity to select next and after getting result next activity is selected.

![alt text](https://github.com/Nice-Internship-2022-23/Money-Withdraw-Workflow/blob/main/workflow_image.drawio%20(1).png?row=true)
