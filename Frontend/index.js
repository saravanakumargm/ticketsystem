document.addEventListener("DOMContentLoaded", () => {
    const stopsTable = document.getElementById("stopsTable");

    fetch("http://localhost:8080/user/get-all/1")
        .then(response => {
            if (!response.ok) {
                throw new Error("Network response was not ok " + response.statusText);
            }
            return response.json();
        })
        .then(data => {
            stopsTable.innerHTML = ""; 
            data.forEach(stop => {
                const row = document.createElement("tr");

                const stopNameCell = document.createElement("td");
                stopNameCell.textContent = stop.stopName;

                const passengerCountCell = document.createElement("td");
                passengerCountCell.textContent = stop.noOfPassengers;

                row.appendChild(stopNameCell);
                row.appendChild(passengerCountCell);
                stopsTable.appendChild(row);
            });
        })
        .catch(error => {
            console.error("Error fetching data:", error);
            stopsTable.innerHTML = "<tr><td colspan='2'>Failed to load data. Please try again later.</td></tr>";
        });

    let stopNo = Number(1);
    const maxStop = 8;
    const intervalTime = 5000;
    const passengersElement = document.getElementById("stopPassengers");
    const stopNameElement  = document.getElementById("nextStop");
    const fetchData = () => {
        fetch(`http://localhost:8080/user/stop/1/${stopNo}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error("Network response was not ok " + response.statusText);
                }
                return response.text();
            })
            .then(data => {
                console.log("Stop Name Data:", data);
                stopNameElement.textContent = JSON.stringify(data);
            })
            .catch(error => {
                console.error("Error fetching stop name:", error);
                stopNameElement.textContent = "Failed to load stop name. Please try again later.";
            });

        fetch(`http://localhost:8080/user/passenger-no/1/${stopNo}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error("Network response was not ok " + response.statusText);
                }
                return response.json();
            })
            .then(data => {
                console.log("Passenger Data:", data);
                passengersElement.textContent =  data;
            })
            .catch(error => {
                console.error("Error fetching passenger data:", error);
                passengersElement.textContent = "Failed to load passenger data. Please try again later.";
            });

        stopNo++;

        if (stopNo > maxStop) {
            clearInterval(timer);
            stopNameElement.textContent += " (End of stops)";
            passengersElement.textContent += " (End of stops)";
        }
    };

const timer = setInterval(fetchData, intervalTime);

});
