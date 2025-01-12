# AWS Cloud Practitioner Essentials

## Cloud Computing
+ Benefits:
  + Trade upfront expense for variable expense
  + Stop spending money to run and maintain data centers
  + Stop guessing capacity
  + Benefit from massive economies of scale
  + Increase speed and agility
  + Go global in minutes
+ On-premises deployment = private cloud deployment: resources are deployed on premises by using virtualization and resource management tools
+ hybrid deployment: cloud-based resources are connected to on-premises infrastructure

## Compute in the cloud
### EC2: Amazon Elastic Compute Cloud (Amazon EC2)
+ **On-premises**: buy hardwares, install physical servers, make all the configurations
+ **Multitenancy**: sharing physical host machine between virtual machines
+ Configurations: OS, apps, databases, storage
+ Vertical Scaling: change the cpu, storage
+ Networking: public/private request
+ Compute as a Service (CaaS)

### Amazon EC2 Instance Types
+ Each EC2 instance type is grouped under an instance family
+ Main features: computing, memory, networking resource
+ EC2 Instance Types: 
  + General purpose: balanced resource, diverse workloads
    + web servers, code repositories
  + Compute optimized: compute intensive tasks
    + gaming servers, High Performance Computing(HPC), scientific modeling
  + Memory optimized: if requires large amounts of data to be preloaded before running an application
    + high-performance databases
  + Accelerated computing: use hardware accelerators
    + floating point number calculations, graphics processing, data pattern matching
  + Storage optimized: high performance for locally stored data
    + distributed file systems, data warehousing applications, and high-frequency online transaction processing (OLTP) systems
+ EC2 pricing:
  + On-demand: per month/per second, get a baseline for usage
  + Reserved Instances: one year/three years,
    + Standard Reserved Instances: instance type and size, OS, tenancy are fixed
    + Convertible Reserved Instances
  + Savings Plans: one year/three years, save up to 72%
    + need flexibility in usage over the duration of the **commitment term**
    + make an hourly spend commitment
  + Spot Instances: require spare EC2 computing capacity, instance may be interrupted
    + up to 90% off to on-demand
    + AWS can reclaim the instance at any time, 2 minute warning, can be resumed later
  + Dedicated Host: nobody share the tenancy

### Scalability and Elasticity
+ Amazon EC2 Auto Scaling
  + **Dynamic scaling**: responds to changing demand
  + **Predictive scaling**: automatically schedules the right number of Amazon EC2 instances based on predicted demand
  + Set up: Auto Scaling group: minimum capacity, desired capacity, maximum capacity
    + pay for only the instances you use

### Load Balancing 负载平衡
+ Properly distribute traffic with:
  + high performance
  + cost-efficient
  + highly available
  + automatically scalable
+ Elastic Load Balancing **ELB**: direct traffic
  + Regional construct 
+ **tightly coupled**: if a single component fails, the whole system fails
+ **loosely coupled** architecture: single failure wont cause cascading failures
  + Amazon Simple Queue Service (SQS)
    + Send - store - receive messages
    + between software components
    + at ant volume
    + SQS queues: where massages are placed until they are processed
  + Amazon Simple Notification Service (SNS)
    + publish/subscribe model
    + SNS topic: a channel for messages to be delivered
    + send 1 message to topic, and send to all subscribe
    + subscribers can be web servers, email addresses, AWS Lambda functions, or several other options
+ **payload**: data contained within a message

#### Monolithic applications and microservices
+ **Monolithic applications**: an application with tightly coupled components
  + if a single component fails, other components fail
+ **microservices**: application components are loosely coupled

### Serverless 
+ You cannot see or access the underlying infrastructure
+ AWS Lambda
  + Upload your code to Lambda function
  + Set up a trigger
  + trigger send request to lambda function, done in 15 mins
  + Charges only when your code is running
  + no VM, no EC2 instance, just code
+ Need access to the underlying 
+ **container**: Docker container (a package for codes)
+ **container orchestration**: manage the containers: automatically provisions, deploys, scales, and manages containerized applications without worrying about the underlying infrastructure
+ container orchestration tools: AWS container services
  + Amazon Elastic Container Service (ECS)
  + Amazon Elastic Kubernetes Service (EKS)
  + AWS Fargate: a serverless compute engine for containers

## Global infrastructure and Reliability
+ data centers all over the world
+ Regions: geographically isolated areas
+ choose the region:
  + **compliance**: data must in the region
  + **proximity**: how close to your customers
  + **feature availability**: some region has no certain AWS services
  + **pricing**
+ Availability Zone(AZ): a single data center or a group of data centers within a Region
  + A best practice is to run applications across at least two Availability Zones in a Region

### Edge Locations (CDN) - Amazon CloudFront
+ An **edge location** is a site that Amazon CloudFront uses to store cached copies of your content closer to your customers for faster delivery.
+ Domain Name Services(DNS): Amazon Route 53
+ AWS Outposts: using AWS in your own building

### Provision AWS Resources
+ API (Application programming interface)
  + AWS Management Console: browser based
    + test enviroments
    + view AWS bills
    + view monitoring
    + work with non-technical resources
  + AWS Command Line Interface (CLI)
    + Make API calls using the terminal on your machine
  + AWS Software Development Kits (SDKs)
    + interact with AWS resources through various programming languages
  + AWS CloudFormation
+ Manage tools: AWS Elastic Beanstalk
  + application code, desired configurations -> AWS Elastic Beanstalk
  + save environment configurations
+ AWS CloudFormation: infrastructure as Code tool
  + to define a wide variety of AWS resources
  + CloudFormation templates: JSON or YAML text-based documents