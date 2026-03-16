import requests
import sqlite3


# class for logger
class GridLogger:

    # Essentially a constructor. Self is the object being made, rest of parameters used to define object. self.fieldName defines the "fields" of the object.
    def __init__(self, api_url, db_name):
        self.api_url = api_url
        self.db_name = db_name

    # function, passing self, getting its api url to fetch, or request data (acting as client). Then checking if request was fulfilled and returning fetched data in json format.
    def fetch_grid_data(self):
        response = requests.get(self.api_url)
        if (response.status_code == 200):
            return response.json()
        else:
            return "Error: Get Request Failed"
        

    def setup_db(self):
        # opens communication to DB. Creates or Opens file
        connection = sqlite3.connect(self.db_name)
        #executes sql commands
        cursor = connection.cursor()
        # defines table structre?
        cursor.execute('''CREATE TABLE IF NOT EXISTS grid_conditions (
                       id INTEGER PRIMARY KEY AUTOINCREMENT,
                       timestamp TEXT,
                       temperature REAL,
                       windspeed REAL
                       )
                       ''')
        # saves edits
        connection.commit()
        #saves and releases file
        connection.close()

    def log_current_conditions(self):
        data = self.fetch_grid_data()
        temp = data['current_weather']['temperature']
        wind = data['current_weather']['windspeed']
        timestamp = data['current_weather']['time']
        connection = sqlite3.connect(self.db_name)
        cursor = connection.cursor()
        cursor.execute('''
                        INSERT INTO grid_conditions (timestamp, temperature, windspeed)
                       VALUES (?,?,?)
                       ''',
                       (timestamp, temp, wind))
        connection.commit()
        connection.close()
        print(f"Logged condition at {timestamp}: Temp {temp}, Wind {wind}")

if __name__ == "__main__":
    API_URL = "https://api.open-meteo.com/v1/forecast?latitude=39.1836&longitude=-96.5717&current_weather=true"
    DB_FILE = "evergy_grid.db"

    logger = GridLogger(API_URL, DB_FILE)
    logger.setup_db()
    print(f"Database setup complete. Look for '{DB_FILE}' in VS Code explorer")
    logger.log_current_conditions()

