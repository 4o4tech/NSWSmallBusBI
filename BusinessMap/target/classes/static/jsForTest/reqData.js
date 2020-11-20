// Train Station Entries and Exits in 2019
(function () {

    var keywords = getUrlParam("keywords");

    $("#current").html(keywords);

    $.ajax({

        type: 'get',

        url: '/getTrainStationTimetableList',

        data:{"keywords":keywords},

        success: function (data) {
            var arr = data;
            var dateList = [];
            var entryNumberList = [];
            var exitNumberList = [];

            var entryNumberCount = 0;
            var exitNumberCount = 0;

            for (var i in arr) {
                dateList.push(arr[i].durationTime);
                entryNumberList.push(arr[i].entryNumber);
                exitNumberList.push(arr[i].exitNumber);
                exitNumberCount = exitNumberCount + arr[i].exitNumber;
                entryNumberCount = entryNumberCount + arr[i].entryNumber;
            }

            $("#totalNumber").html(entryNumberCount);
            $("#exitsNumber").html(exitNumberCount);

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

            var loadOption;

            if(data.length == 0){
                loadOption = {
                    title: {
                        text: 'Sorry, No Result in this Area. Try Another Address!',
                        x: 'center',
                        y: 'center',
                        textStyle: {
                            color: '#65ABE7',
                            fontWeight: 'normal',
                            fontSize: 16
                        }
                    }
                }

            }else{
                loadOption = option
            }

            // 3. 把配置和数据给实例对象
            myChart.setOption(loadOption);


            // // 使用刚指定的配置项和数据显示图表。
            // myChart.setOption(option);

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
    var houseCount = 0;
    var unitCount = 0;

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
                    houseCount = houseCount + arr[i].priceValue;
                }else{
                    unitList.push(arr[i].priceValue);
                    unitCount = unitCount + arr[i].priceValue;
                }
            }

            $("#houseCount").html((houseCount/12).toFixed(2));
            $("#unitCount").html((unitCount/12).toFixed(2));

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

            var loadOption;

            if(data.length == 0){
                loadOption = {
                    title: {
                        text: 'Sorry, No Result in this Area. Try Another Address!',
                        x: 'center',
                        y: 'center',
                        textStyle: {
                            color: '#65ABE7',
                            fontWeight: 'normal',
                            fontSize: 16
                        }
                    }
                }

                }else{
                loadOption = option
            }

            // 3. 把配置和数据给实例对象
            myChart.setOption(loadOption);

            // 重新把配置好的新数据给实例对象
            // myChart.setOption(option);
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

    var count2018 = 0;
    var count2019 = 0;

    $.ajax({

        type: 'get',

        url: '/getCrimeNumberList',

        data: {"keywords": keywords},

        success: function (data) {
            var arr = data;
            for (var i in arr) {
                if(arr[i].month.substring(0,4) == "2018"){
                    list.push(arr[i].num);
                    count2018 = count2018 + arr[i].num;
                }else{
                    list1.push(arr[i].num);
                    count2019 = count2019 + arr[i].num;
                }

            }

            $("#count2018").html(count2018);
            $("#count2019").html(count2019);

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


            var loadOption;

            if(data.length === 0){
                loadOption = {
                    title: {
                        text: 'Sorry, No Result in this Area. Try Another Address!',
                        x: 'center',
                        y: 'center',
                        textStyle: {
                            color: '#65ABE7',
                            fontWeight: 'normal',
                            fontSize: 16
                        }
                    }
                }

            }else{
                loadOption = option
            }

            // 3. 把配置和数据给实例对象
            myChart.setOption(loadOption);
aj
            // // 3. 把配置和数据给实例对象
            // myChart.setOption(option);

            window.addEventListener("resize", function () {
                myChart.resize();
            });
        }
    })
})();

// pie chart function
(function () {

    var keywords = getUrlParam("keywords");

    $.ajax({

        type: 'get',

        url: '/getPieList',

        data: {"keywords": keywords},

        success: function (data) {
            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.querySelector(".pie .chart"));

            var busStation = data["busStation"];
            var bank = data["bank"];
            var park = data["park"];
            var shoppingMall = data["shoppingMall"];
            var touristAttraction = data["touristAttraction"];

            var option = {
                title:{
                    text: 'The composition of some important places in this suburb',
                    x:'center',
                    y:'bottom',
                    textStyle:{
                        fontSize:18,
                        fontWeight: "bolder",
                    }
                },
                tooltip: {
                    trigger: 'item',
                    formatter: '{a} <br/>{b} : {c} ({d}%)'
                },
                legend: {
                    orient: 'vertical',
                    left: 'left',
                    data: ['Shopping Mall', 'Bus Station', 'Tourist attraction', 'Bank', 'Park']
                },
                series: [
                    {
                        name:'Place',
                        type: 'pie',
                        radius: '60%',
                        center: ['60%', '40%'],
                        data: [
                            {value: shoppingMall, name: 'Shopping Mall'},
                            {value: busStation, name: 'Bus Station'},
                            {value: touristAttraction, name: 'Tourist attraction'},
                            {value: bank, name: 'Bank'},
                            {value: park, name: 'Park'}
                        ],
                        emphasis: {
                            itemStyle: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }
                    }
                ]};
            myChart.setOption(option);
            window.addEventListener("resize", function () {
                myChart.resize();
            });
        }
    })
})();
