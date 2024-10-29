import pandas as pd
import numpy as np
from sklearn.preprocessing import StandardScaler

features = [
    "battery_power",
    "clock_speed",
    "fc",
    "int_memory",
    "m_dep",
    "mobile_wt",
    "n_cores",
    "pc",
    "px_height",
    "px_width",
    "ram",
    "sc_h",
    "sc_w",
    "talk_time",
]


def feature_engineering(data):
    data["sc_size"] = data["sc_h"] * data["sc_w"]
    data["log-ram"] = np.log1p(data["ram"])
    data["log-int_memory"] = np.log1p(data["int_memory"])
    data["log-battery_power"] = np.log1p(data["battery_power"])

    return data


def preprocess(data, scaler):
    data = feature_engineering(data)

    # Fill null values in new features
    data.fillna(0, inplace=True)

    data[features] = scaler.transform(data[features])

    return data
