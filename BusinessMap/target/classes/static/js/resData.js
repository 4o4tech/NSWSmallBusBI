function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + x + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg); //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}

// crime rate Two years data
(function () {

    var keywords = code;
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
