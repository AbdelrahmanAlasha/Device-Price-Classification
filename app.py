from flask import Flask, request, jsonify
import joblib
import pandas as pd
import os
import requests
from feature_engineering import preprocess, features

app = Flask(__name__)

# Load the models
model = joblib.load("device-classification/models/svc_model.pkl")
scaler = joblib.load("device-classification/models/scaler_model.pkl")
counter = 1


def save_predictions_to_csv(predictions, filename="predictions.csv"):
    global counter  # Access the global counter

    try:
        data = request.get_json()

        current_id = counter

        # Create a DataFrame with ID, features, and prediction
        df = pd.DataFrame({"id": current_id, **data, "Prediction": predictions})

        file_exists = os.path.exists(filename)

        # Open in append mode
        with open(filename, "a", newline="") as f:
            # Write header only if the file does not exist
            f.write(df.to_csv(index=False, header=not file_exists))

        print(f"Predictions saved successfully to {filename}")

        counter += 1

    except Exception as e:
        print(f"Error saving predictions to CSV: {e}")
        return jsonify({"error": "Error saving predictions to CSV"}), 500


@app.route("/predict/<int:id>", methods=["POST"])
def predict(id):
    spring_boot_url = f"http://localhost:8080/api/devices/{id}"
    response = requests.get(spring_boot_url)
    if response.status_code != 200:
        return jsonify({"error": "Device not found"}), 404

    data = response.json()
    filtered_data = {k: v for k, v in sorted(data.items()) if k != "id"}
    input_data = pd.DataFrame([filtered_data])

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
