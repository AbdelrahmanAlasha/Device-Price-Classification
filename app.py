from flask import Flask, request, jsonify
import joblib
import pandas as pd
import os
from feature_engineering import preprocess, features

app = Flask(__name__)

# Load the models
model = joblib.load("device-classification/models/svc_model.pkl")
scaler = joblib.load("device-classification/models/scaler_model.pkl")

# Define a function to save predictions to CSV
def save_predictions_to_csv(predictions, filename="predictions.csv"):

    try:
        
        data = request.get_json() 

        # Create a DataFrame with ID, features, and prediction
        df = pd.DataFrame({**data, "Prediction": predictions})

        # Open in append mode
        with open(filename, 'a' , newline='') as f:
            if not os.path.exists(filename):
                # Write header row on first entry
                f.write(df.to_csv(index=False, header=True))
            else:
                f.write(df.to_csv(index=False, header=False))

        print(f"Predictions saved successfully to {filename}")
    except Exception as e:
        print(f"Error saving predictions to CSV: {e}")
        
@app.route("/predict/<int:id>", methods=["POST"])
def predict(id):
    data = request.get_json()
    input_data = pd.DataFrame([data])

    try:
        processed_data = preprocess(input_data, scaler)
        prediction = model.predict(processed_data)

        # Save the prediction(s) to CSV
        save_predictions_to_csv(prediction)

        return jsonify({"prediction": int(prediction[0])})

    except Exception as e:
        print(f"Error during prediction for ID {id}: {e}")
        return jsonify({"error": "An error occurred during prediction."}), 500

if __name__ == "__main__":
    app.run(debug=True)