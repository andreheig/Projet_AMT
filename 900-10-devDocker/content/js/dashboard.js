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
    createTable($("#apdexTable"), {"supportsControllersDiscrimination": true, "overall": {"data": [0.9999523809523809, 500, 1500, "Total"], "isController": false}, "titles": ["Apdex", "T (Toleration threshold)", "F (Frustration threshold)", "Label"], "items": [{"data": [1.0, 500, 1500, "Requête HTTP dev login-1"], "isController": false}, {"data": [0.9996666666666667, 500, 1500, "Requête HTTP dev login-0"], "isController": false}, {"data": [0.9996666666666667, 500, 1500, "Requête HTTP dev login"], "isController": false}, {"data": [1.0, 500, 1500, "Requête HTTP dev page 10"], "isController": false}, {"data": [1.0, 500, 1500, "Requête HTTP dev page 1"], "isController": false}, {"data": [1.0, 500, 1500, "Requête HTTP dev page 7"], "isController": false}, {"data": [1.0, 500, 1500, "Requête HTTP dev page 6"], "isController": false}, {"data": [1.0, 500, 1500, "Requête HTTP dev page 9"], "isController": false}, {"data": [1.0, 500, 1500, "Requête HTTP dev page 8"], "isController": false}, {"data": [1.0, 500, 1500, "Requête HTTP dev page 3"], "isController": false}, {"data": [1.0, 500, 1500, "Requête HTTP dev page 2"], "isController": false}, {"data": [1.0, 500, 1500, "Requête HTTP dev deco"], "isController": false}, {"data": [1.0, 500, 1500, "Requête HTTP dev page 5"], "isController": false}, {"data": [1.0, 500, 1500, "Requête HTTP dev page 4"], "isController": false}]}, function(index, item){
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
    createTable($("#statisticsTable"), {"supportsControllersDiscrimination": true, "overall": {"data": ["Total", 126000, 0, 0.0, 14.615023809523535, 0, 1069, 3.0, 5.0, 13.0, 1221.273419856355, 4718.991634640548, 212.8198421794884], "isController": false}, "titles": ["Label", "#Samples", "KO", "Error %", "Average", "Min", "Max", "90th pct", "95th pct", "99th pct", "Throughput", "Received", "Sent"], "items": [{"data": ["Requête HTTP dev login-1", 9000, 0, 0.0, 15.106111111111124, 1, 190, 61.0, 79.0, 102.98999999999978, 87.31590895861225, 710.1239158274637, 15.433769063973456], "isController": false}, {"data": ["Requête HTTP dev login-0", 9000, 0, 0.0, 19.814666666666763, 2, 1065, 71.0, 93.0, 122.0, 87.23804354147684, 43.88312131661594, 26.077700320357483], "isController": false}, {"data": ["Requête HTTP dev login", 9000, 0, 0.0, 35.007555555555506, 3, 1069, 133.0, 171.0, 217.98999999999978, 87.23719794120213, 753.3664698377388, 41.49730382535113], "isController": false}, {"data": ["Requête HTTP dev page 10", 9000, 0, 0.0, 12.190111111111108, 0, 210, 55.0, 72.0, 96.0, 87.4236257491719, 292.66424713687627, 11.952448832894596], "isController": false}, {"data": ["Requête HTTP dev page 1", 9000, 0, 0.0, 12.271222222222184, 0, 196, 55.0, 71.0, 95.0, 87.35489381527351, 292.43415624878673, 11.260591780875101], "isController": false}, {"data": ["Requête HTTP dev page 7", 9000, 0, 0.0, 12.227666666666584, 0, 151, 55.0, 72.0, 97.0, 87.40834264070315, 292.6130845432914, 11.864999635798572], "isController": false}, {"data": ["Requête HTTP dev page 6", 9000, 0, 0.0, 12.209777777777797, 0, 183, 55.0, 72.0, 96.0, 87.40324945858542, 292.5960343203426, 11.864308276116576], "isController": false}, {"data": ["Requête HTTP dev page 9", 9000, 0, 0.0, 12.210888888888901, 0, 207, 55.0, 73.0, 97.0, 87.4185307858926, 292.64719095121075, 11.866382596913153], "isController": false}, {"data": ["Requête HTTP dev page 8", 9000, 0, 0.0, 12.17711111111115, 0, 173, 55.0, 71.0, 96.0, 87.41598352694355, 292.6386636038696, 11.866036826411282], "isController": false}, {"data": ["Requête HTTP dev page 3", 9000, 0, 0.0, 12.273333333333355, 0, 199, 56.0, 72.94999999999891, 96.0, 87.38627647075958, 292.53921459156624, 11.862004325620685], "isController": false}, {"data": ["Requête HTTP dev page 2", 9000, 0, 0.0, 12.383111111111063, 0, 180, 56.0, 73.0, 96.0, 87.37948912125361, 292.5164928785716, 11.861082995951417], "isController": false}, {"data": ["Requête HTTP dev deco", 9000, 0, 0.0, 12.160444444444476, 0, 212, 55.0, 73.0, 97.0, 87.43041995745052, 292.686991810684, 11.95337772855769], "isController": false}, {"data": ["Requête HTTP dev page 5", 9000, 0, 0.0, 12.256444444444478, 0, 207, 55.900000000000546, 73.0, 96.98999999999978, 87.39900559353636, 292.58182731898694, 11.863732204591361], "isController": false}, {"data": ["Requête HTTP dev page 4", 9000, 0, 0.0, 12.32188888888888, 0, 195, 56.0, 72.0, 96.0, 87.39561079821324, 292.57046271120606, 11.863271387648087], "isController": false}]}, function(index, item){
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
