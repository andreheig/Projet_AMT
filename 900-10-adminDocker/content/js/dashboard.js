/*
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
var showControllersOnly = false;
var seriesFilter = "";
var filtersOnlySampleSeries = true;

/*
 * Add header in statistics table to group metrics by category
 * format
 *
 */
function summaryTableHeader(header) {
    var newRow = header.insertRow(-1);
    newRow.className = "tablesorter-no-sort";
    var cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 1;
    cell.innerHTML = "Requests";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 3;
    cell.innerHTML = "Executions";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 7;
    cell.innerHTML = "Response Times (ms)";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 2;
    cell.innerHTML = "Network (KB/sec)";
    newRow.appendChild(cell);
}

/*
 * Populates the table identified by id parameter with the specified data and
 * format
 *
 */
function createTable(table, info, formatter, defaultSorts, seriesIndex, headerCreator) {
    var tableRef = table[0];

    // Create header and populate it with data.titles array
    var header = tableRef.createTHead();

    // Call callback is available
    if(headerCreator) {
        headerCreator(header);
    }

    var newRow = header.insertRow(-1);
    for (var index = 0; index < info.titles.length; index++) {
        var cell = document.createElement('th');
        cell.innerHTML = info.titles[index];
        newRow.appendChild(cell);
    }

    var tBody;

    // Create overall body if defined
    if(info.overall){
        tBody = document.createElement('tbody');
        tBody.className = "tablesorter-no-sort";
        tableRef.appendChild(tBody);
        var newRow = tBody.insertRow(-1);
        var data = info.overall.data;
        for(var index=0;index < data.length; index++){
            var cell = newRow.insertCell(-1);
            cell.innerHTML = formatter ? formatter(index, data[index]): data[index];
        }
    }

    // Create regular body
    tBody = document.createElement('tbody');
    tableRef.appendChild(tBody);

    var regexp;
    if(seriesFilter) {
        regexp = new RegExp(seriesFilter, 'i');
    }
    // Populate body with data.items array
    for(var index=0; index < info.items.length; index++){
        var item = info.items[index];
        if((!regexp || filtersOnlySampleSeries && !info.supportsControllersDiscrimination || regexp.test(item.data[seriesIndex]))
                &&
                (!showControllersOnly || !info.supportsControllersDiscrimination || item.isController)){
            if(item.data.length > 0) {
                var newRow = tBody.insertRow(-1);
                for(var col=0; col < item.data.length; col++){
                    var cell = newRow.insertCell(-1);
                    cell.innerHTML = formatter ? formatter(col, item.data[col]) : item.data[col];
                }
            }
        }
    }

    // Add support of columns sort
    table.tablesorter({sortList : defaultSorts});
}

$(document).ready(function() {

    // Customize table sorter default options
    $.extend( $.tablesorter.defaults, {
        theme: 'blue',
        cssInfoBlock: "tablesorter-no-sort",
        widthFixed: true,
        widgets: ['zebra']
    });

    var data = {"OkPercent": 100.0, "KoPercent": 0.0};
    var dataset = [
        {
            "label" : "KO",
            "data" : data.KoPercent,
            "color" : "#FF6347"
        },
        {
            "label" : "OK",
            "data" : data.OkPercent,
            "color" : "#9ACD32"
        }];
    $.plot($("#flot-requests-summary"), dataset, {
        series : {
            pie : {
                show : true,
                radius : 1,
                label : {
                    show : true,
                    radius : 3 / 4,
                    formatter : function(label, series) {
                        return '<div style="font-size:8pt;text-align:center;padding:2px;color:white;">'
                            + label
                            + '<br/>'
                            + Math.round10(series.percent, -2)
                            + '%</div>';
                    },
                    background : {
                        opacity : 0.5,
                        color : '#000'
                    }
                }
            }
        },
        legend : {
            show : true
        }
    });

    // Creates APDEX table
    createTable($("#apdexTable"), {"supportsControllersDiscrimination": true, "overall": {"data": [0.999234126984127, 500, 1500, "Total"], "isController": false}, "titles": ["Apdex", "T (Toleration threshold)", "F (Frustration threshold)", "Label"], "items": [{"data": [1.0, 500, 1500, "Requête HTTP admin page 4"], "isController": false}, {"data": [1.0, 500, 1500, "Requête HTTP admin page 5"], "isController": false}, {"data": [0.998, 500, 1500, "Requête HTTP admin login-1"], "isController": false}, {"data": [1.0, 500, 1500, "Requête HTTP admin page 6"], "isController": false}, {"data": [1.0, 500, 1500, "Requête HTTP admin page 7"], "isController": false}, {"data": [1.0, 500, 1500, "Requête HTTP admin page 8"], "isController": false}, {"data": [1.0, 500, 1500, "Requête HTTP admin page 9"], "isController": false}, {"data": [1.0, 500, 1500, "Requête HTTP admin deco"], "isController": false}, {"data": [1.0, 500, 1500, "Requête HTTP admin page 10"], "isController": false}, {"data": [0.9935, 500, 1500, "Requête HTTP admin login"], "isController": false}, {"data": [0.9978333333333333, 500, 1500, "Requête HTTP admin login-0"], "isController": false}, {"data": [0.9999444444444444, 500, 1500, "Requête HTTP admin page 1"], "isController": false}, {"data": [1.0, 500, 1500, "Requête HTTP admin page 2"], "isController": false}, {"data": [1.0, 500, 1500, "Requête HTTP admin page 3"], "isController": false}]}, function(index, item){
        switch(index){
            case 0:
                item = item.toFixed(3);
                break;
            case 1:
            case 2:
                item = formatDuration(item);
                break;
        }
        return item;
    }, [[0, 0]], 3);

    // Create statistics table
    createTable($("#statisticsTable"), {"supportsControllersDiscrimination": true, "overall": {"data": ["Total", 126000, 0, 0.0, 44.394079365078426, 0, 3602, 5.0, 7.0, 12.0, 1246.8827930174564, 5489.224065951193, 221.1094751959387], "isController": false}, "titles": ["Label", "#Samples", "KO", "Error %", "Average", "Min", "Max", "90th pct", "95th pct", "99th pct", "Throughput", "Received", "Sent"], "items": [{"data": ["Requête HTTP admin page 4", 9000, 0, 0.0, 37.674666666666596, 0, 303, 129.0, 146.0, 191.0, 93.10601671770256, 311.68693877762144, 12.820262067574278], "isController": false}, {"data": ["Requête HTTP admin page 5", 9000, 0, 0.0, 37.036333333333474, 0, 304, 128.0, 146.0, 188.0, 93.21305397035825, 312.0452627054571, 12.835000595527845], "isController": false}, {"data": ["Requête HTTP admin login-1", 9000, 0, 0.0, 54.298555555555666, 4, 1887, 156.0, 184.0, 272.0, 90.62896501721951, 1078.2545710984232, 16.196387302882002], "isController": false}, {"data": ["Requête HTTP admin page 6", 9000, 0, 0.0, 36.817444444444455, 0, 295, 127.0, 144.9499999999989, 188.0, 93.30872747630995, 312.3655447156157, 12.848174388827836], "isController": false}, {"data": ["Requête HTTP admin page 7", 9000, 0, 0.0, 36.73122222222223, 0, 301, 127.0, 145.0, 188.0, 93.40750581202259, 312.6962206285287, 12.861775702632016], "isController": false}, {"data": ["Requête HTTP admin page 8", 9000, 0, 0.0, 36.52455555555538, 0, 306, 127.0, 146.9499999999989, 189.98999999999978, 93.48415443582313, 312.9528138730485, 12.872329858838928], "isController": false}, {"data": ["Requête HTTP admin page 9", 9000, 0, 0.0, 36.9965555555554, 0, 322, 128.0, 147.0, 192.0, 93.57065624220245, 313.24239218581056, 12.884240752100142], "isController": false}, {"data": ["Requête HTTP admin deco", 9000, 0, 0.0, 37.595777777777684, 0, 307, 131.0, 150.0, 194.0, 93.74316456091742, 313.81989073713373, 12.81644827981293], "isController": false}, {"data": ["Requête HTTP admin page 10", 9000, 0, 0.0, 37.18999999999981, 0, 314, 129.0, 148.0, 193.0, 93.66414120389643, 313.5553477021064, 12.988582081009076], "isController": false}, {"data": ["Requête HTTP admin login", 9000, 0, 0.0, 103.01700000000001, 6, 3602, 300.0, 354.0, 501.0, 89.06570079862244, 1104.806091908381, 43.410831316984826], "isController": false}, {"data": ["Requête HTTP admin login-0", 9000, 0, 0.0, 48.659888888888894, 1, 1795, 146.0, 171.0, 262.0, 89.06922658221585, 45.15218312385571, 27.49490480726409], "isController": false}, {"data": ["Requête HTTP admin page 1", 9000, 0, 0.0, 40.62211111111135, 0, 501, 135.0, 161.0, 248.98999999999978, 92.3247368744999, 309.0714824275251, 12.081557364436511], "isController": false}, {"data": ["Requête HTTP admin page 2", 9000, 0, 0.0, 39.739444444444345, 0, 316, 133.0, 157.0, 231.0, 92.78350515463917, 310.60728092783506, 12.775853737113403], "isController": false}, {"data": ["Requête HTTP admin page 3", 9000, 0, 0.0, 38.61355555555539, 0, 323, 130.0, 151.0, 217.98999999999978, 92.99057695486857, 311.3004861340717, 12.804366553355926], "isController": false}]}, function(index, item){
        switch(index){
            // Errors pct
            case 3:
                item = item.toFixed(2) + '%';
                break;
            // Mean
            case 4:
            // Mean
            case 7:
            // Percentile 1
            case 8:
            // Percentile 2
            case 9:
            // Percentile 3
            case 10:
            // Throughput
            case 11:
            // Kbytes/s
            case 12:
            // Sent Kbytes/s
                item = item.toFixed(2);
                break;
        }
        return item;
    }, [[0, 0]], 0, summaryTableHeader);

    // Create error table
    createTable($("#errorsTable"), {"supportsControllersDiscrimination": false, "titles": ["Type of error", "Number of errors", "% in errors", "% in all samples"], "items": []}, function(index, item){
        switch(index){
            case 2:
            case 3:
                item = item.toFixed(2) + '%';
                break;
        }
        return item;
    }, [[1, 1]]);

        // Create top5 errors by sampler
    createTable($("#top5ErrorsBySamplerTable"), {"supportsControllersDiscrimination": false, "overall": {"data": ["Total", 126000, 0, null, null, null, null, null, null, null, null, null, null], "isController": false}, "titles": ["Sample", "#Samples", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors"], "items": [{"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}]}, function(index, item){
        return item;
    }, [[0, 0]], 0);

});
