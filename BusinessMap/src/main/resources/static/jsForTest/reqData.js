// Train Station Entries and Exits in 2019
(function () {

    var keywords = getUrlParam("keywords");

    $.ajax({

        type: 'get',

        url: '/getTrainStationTimetableList',

        data:{"keywords":keywords},

        success: function (data) {
            var arr = data;
            var dateList = [];
            var entryNumberList = [];
            var exitNumberList = [];

            for (var i in arr) {
                dateList.push(arr[i].durationTime);
                entryNumberList.push(arr[i].entryNumber);
                exitNumberList.push(arr[i].exitNumber);
            }

            // 实例化对象
            var myChart = echarts.init(document.querySelector(".bar .chart"));
            // 指定配置和数据
            var option = {

                title:{
                    text: 'Train Station Entries and Exits in 2019',
                    x:'right',
                    y:'top',
                    textStyle:{
                        fontSize:17,
                        fontWeight: "bolder",
                    }
                },

                legend: {

                    left:20,
                    textStyle: {
                        fontSize:'12',
                        color: "#040000"
                    }
                },
                tooltip: {
                    trigger: "axis"
                },
                dataset: {
                    source: [
                        [dateList[0], entryNumberList[0], exitNumberList[0]],
                        [dateList[1], entryNumberList[1], exitNumberList[1]],
                        [dateList[2], entryNumberList[2], exitNumberList[2]],
                        [dateList[3], entryNumberList[3], exitNumberList[3]]
                    ]
                },
                xAxis: {type: 'category',
                    axisTick: {
                        show: false
                    }
                },

                yAxis: {
                    axisTick: {
                        show: false
                    },
                },
                // Declare several bar series, each will be mapped
                // to a column of dataset.source by default.
                grid: {
                    top: "20%",
                    left: "3%",
                    right: "4%",
                    bottom: "3%",
                    show: true,
                    borderColor: "#012f4a",
                    containLabel: true
                },
                series: [
                    {
                        name: "Number of Entries",
                        type: 'bar'
                        //data: dataset.source[1]
                    },
                    {
                        name: "Number of Exits",
                        type: 'bar'
                        //data: dataset.source[2]
                    }
                ]
            };

            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
            window.addEventListener("resize", function () {
                myChart.resize();
            });
        }
    });
})();

// Median Weekly Rental price of House and Unit
(function () {

    var keywords = getUrlParam("keywords");
    var houseList = [];
    var unitList = [];
    var dataList = [];

    $.ajax({

        type: 'get',

        url: '/getRentalPriceList',

        data:{"keywords":keywords},

        success: function (data) {
            var arr = data;
            for(var i in arr){

                if(arr[i].dwellingType == "H"){
                    houseList.push(arr[i].priceValue);
                    dataList.push(arr[i].date);
                }else{
                    unitList.push(arr[i].priceValue);
                }
            }

            var myChart = echarts.init(document.querySelector(".line .chart"));

            // 2. 指定配置和数据
            var option = {
                title:{
                    text: 'Median Weekly Rental price of House and Unit',
                    x:'right',
                    y:'top',
                    textStyle:{
                        fontSize:18,
                        fontWeight: "bolder",
                    }
                },
                color: ["#c23531", "#2f4554" ],
                tooltip: {
                    // trigger with axis
                    trigger: "axis"
                },
                legend: {
                    left:"5%",
                    right: "5%",
                    textStyle: {
                        fontSize: '14',
                        color: "#040000"
                    }
                },
                grid: {
                    top: "20%",
                    left: "3%",
                    right: "4%",
                    bottom: "3%",
                    show: true,
                    borderColor: "#012f4a",
                    containLabel: true
                },

                xAxis: {
                    type: "category",
                    boundaryGap: false,
                    data: [
                        dataList[0],
                        dataList[1],
                        dataList[2],
                        dataList[3],
                        dataList[4],
                        dataList[5],
                        dataList[6],
                        dataList[7],
                        dataList[8],
                        dataList[9],
                        dataList[10],
                        dataList[11]
                    ],
                    axisTick: {
                        show: false
                    },
                    axisLine: {
                        show: false
                    }
                },
                yAxis: {
                    type: "value",
                    splitNumber : 3,
                    axisTick: {
                        show: false
                    },
                    // 修改y轴分割线的颜色
                    splitLine: {
                        lineStyle: {
                            color: "#012f4a"
                        }
                    }
                },
                series: [
                    {
                        name: "House",
                        type: "line",
                        smooth: false,
                        data: houseList
                    },
                    {
                        name: "Unit",
                        type: "line",
                        smooth: false,
                        data: unitList
                    },

                ]
            };
            // 3. 把配置和数据给实例对象
            myChart.setOption(option);

            // 重新把配置好的新数据给实例对象
            myChart.setOption(option);
            window.addEventListener("resize", function () {
                myChart.resize();
            });
        }
    });


})();

function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg); //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}

(function () {

    var keywords = getUrlParam("keywords");
    //保存 2018 年数据
    var list = [];
    //保存 2019 年数据
    var list1 = [];

    $.ajax({

        type: 'get',

        url: '/getCrimeNumberList',

        data: {"keywords": keywords},

        success: function (data) {
            var arr = data;
            for (var i in arr) {
                if(arr[i].month.substring(0,4) == "2018"){
                    list.push(arr[i].num);
                }else{
                    list1.push(arr[i].num);
                }

            }

            var myChart = echarts.init(document.querySelector(".radar .chart"));

            // 2. 指定配置和数据
            var option = {
                title:{
                    text: 'The Number of Crimes between 2018 and 2019',
                    x:'right',
                    y:'top',
                    textStyle:{
                        fontSize:18,
                        fontWeight: "bolder",
                    }
                },
                color: ["#c23531", "#2f4554" ],
                tooltip: {
                    // trigger with axis
                    trigger: "axis"
                },
                legend: {
                    left:"5%",
                    right: "5%",
                    textStyle: {
                        fontSize: '14',
                        color: "#040000"
                    }
                },
                grid: {
                    top: "20%",
                    left: "3%",
                    right: "4%",
                    bottom: "3%",
                    show: true,
                    borderColor: "#012f4a",
                    containLabel: true
                },

                xAxis: {
                    type: "category",
                    boundaryGap: false,
                    data: [
                        "Jan.",
                        "Feb.",
                        "Mar.",
                        "Apr.",
                        "May.",
                        "Jun.",
                        "Jul.",
                        "Aug.",
                        "Sept.",
                        "Oct.",
                        "Nov.",
                        "Dec.",

                    ],
                    axisTick: {
                        show: false
                    },
                    axisLine: {
                        show: false
                    }
                },
                yAxis: {
                    type: "value",
                    splitNumber : 3,
                    axisTick: {
                        show: false
                    },
                    // 修改y轴分割线的颜色
                    splitLine: {
                        lineStyle: {
                            color: "#012f4a"
                        }
                    }
                },
                series: [
                    {
                        name: "Year 2018",
                        type: "line",
                        smooth: false,
                        data: list
                    },
                    {
                        name: "Year 2019",
                        type: "line",
                        smooth: false,
                        data: list1
                    },

                ]
            };
            // 3. 把配置和数据给实例对象
            myChart.setOption(option);

            // 重新把配置好的新数据给实例对象
            myChart.setOption(option);
            window.addEventListener("resize", function () {
                myChart.resize();
            });
        }
    })
})();
