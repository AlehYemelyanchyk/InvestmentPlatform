let dates = document.getElementById("dates").getAttribute("value");
let prices = document.getElementById("prices").getAttribute("value");
let securityname = document.getElementById("securityName").getAttribute("value");
let pricetrimmed = prices.substring(1, prices.length - 1);
let datestrimmed = dates.substring(1, dates.length - 1);
let pricepoints = Array.from((pricetrimmed.split(", ")));
let datelabels = Array.from((datestrimmed.split(", ")));

let config = {
    type: 'line',
    data: {
        labels: datelabels,
        datasets: [{
            label: securityname,
            data: pricepoints,
            borderColor: window.chartColors.green,
            backgroundColor: 'rgba(0, 0, 0, 0)',
            fill: false,
            lineTension: 0
        }]
    },
    options: {
        responsive: true,
        title: {
            display: true,
            text: 'Nasdaq Delayed Price. Currency in USD'
        },
        tooltips: {
            mode: 'index'
        },
        scales: {
            xAxes: [{
                display: true,
                scaleLabel: {
                    display: true
                }
            }],
            yAxes: [{
                display: true,
                scaleLabel: {
                    display: true,
                    labelString: 'Value'
                },
                ticks: {
                    suggestedMin: pricepoints[0],
                    suggestedMax: pricepoints[length - 1],
                }
            }]
        }
    }
};

window.onload = function () {
    var ctx = document.getElementById('canvas').getContext('2d');
    window.myLine = new Chart(ctx, config);
};