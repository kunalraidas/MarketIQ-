// WebSocket Setup
const socket = new SockJS('http://localhost:8080/ws/prices');
const stompClient = Stomp.over(socket);

stompClient.connect({}, function (frame) {
    console.log('WebSocket Connected: ' + frame);
    stompClient.subscribe('/topic/price', function (message) {
        document.getElementById("priceDisplay").innerText = message.body;
    });
});

// Search API Call
function searchInstrument() {
    const query = document.getElementById("searchInput").value;

    fetch(`http://localhost:8080/api/search?query=${query}`)
        .then(response => response.json())
        .then(data => {
            document.getElementById("searchResult").innerHTML = `
                <p><strong>Name:</strong> ${data.name}</p>
                <p><strong>Symbol:</strong> ${data.symbol}</p>
                <p><strong>Price:</strong> $${data.price}</p>
            `;
        })
        .catch(error => {
            console.error('API Error:', error);
            document.getElementById("searchResult").innerText = "Error fetching data.";
        });
}
