# Device Price Classification System Using AI, Java Spring Boot and Flask
# Project Intro
This project is an AI-based system designed to classify device prices based on their characteristics

The project mainly consist of 3 parts:

**1-Notebooks:** Includes the trained AI models, EDA, and feature engineering notebooks

**2-Java Spring Boot App:** Includes the endpoints, entities and controller for storing, retreiving and manipulating devices data

**3- Flask Server Includes a simple Flask app to do the prediction for device:**

# Java App
## 1-Navigate to 'java' Directory
```
cd java
```

## 2-Clean and Install
```
mvn clean install
```

## 3-Run the Server
```
mvn spring-boot:run
```

# Python App

### 1-Clone The Repository
```
git clone https://github.com/AbdelrahmanAlasha/Device-Price-Classification.git
```

### 2-Create Virtual Environment and Activate it
```
python -m venv venv
venv\Scripts\activate #on Windows
source venv/bin/activate #on Linux
```
### 3-Download Dependencies
```
pip install -r requirements.txt
```

## 4-Run app.py##
```
python app.py` or `flask run
```

# API Endpoints
## Java
- **GET /api/devices**: to retreive all devices in database

- **GET /api/devices/{id}**: to retreive specific device

- **POST /api/devices/**: to add a new device

## FLask Server for Prediction
- **POST /predict/{id}** Receives an id to predict the price range




  
