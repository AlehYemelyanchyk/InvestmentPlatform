function isClosed(symbol, date) {
    if (date !== '') {
        event.preventDefault();
        swal("For your information!", "We're going to stop trading " + symbol + " on " + date + " at 00:00:00 AM. Please, contact our support team for more information.")
            .then(() => {
                document.getElementById("form".concat(symbol)).submit();
            });
    }
}