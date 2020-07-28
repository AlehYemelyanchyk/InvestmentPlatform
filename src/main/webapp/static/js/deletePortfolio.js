function deletePortfolio(symbol) {
    event.preventDefault();
    swal({
        title: "Are you sure?",
        text: "Once deleted \"" + symbol + "\" portfolio, you will loose all its securities and transactions.",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((willDelete) => {
            if (willDelete) {
                swal("Done! \"" + symbol + "\" portfolio has been deleted!", {
                    icon: "success",
                }).then(() => {
                    document.getElementById("formRemove".concat(symbol)).submit();
                });
            } else {
                swal("\"" + symbol + "\" portfolio will not be deleted!");
            }
        });
}