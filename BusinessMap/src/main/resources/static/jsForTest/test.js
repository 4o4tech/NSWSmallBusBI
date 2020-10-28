// bar chart function
(function () {
  // 实例化对象
  var myChart = echarts.init(document.querySelector(".bar .chart"));
  // 指定配置和数据
  var option = {
    legend: {
      textStyle: {
        color: "#040000"
      }
    },
    tooltip: {
      trigger: "axis"
    },
    dataset: {
        source: [
            ['product', '2015', '2016', '2017'],
            ['Data1', 43.3, 500.8, 93.7],
            ['Data2', 83.1, 203.4, 405.1],
            ['Data3', 506.4, 65.2, 82.5],
            ['Data4', 300.4, 353.9, 539.1]
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
        name: "Year1",
        type: 'bar'
        //data: dataset.source[1]
      },
      {
        name: "Year2",
        type: 'bar'
        //data: dataset.source[2]
      },
      {
        name: "Year3",
        type: 'bar'
        //data: dataset.source[3]
      }
    ]
  };

  // 使用刚指定的配置项和数据显示图表。
  myChart.setOption(option);
  window.addEventListener("resize", function () {
    myChart.resize();
  });
})();

// Line chart function
(function () {
  var myChart = echarts.init(document.querySelector(".line .chart"));
  var data = {
    year: [
      [24, 40, 101, 134, 90, 230, 210, 230, 120, 230, 210, 120],
      [40, 64, 191, 324, 290, 330, 310, 213, 180, 200, 180, 79],
      [820, 932, 901, 934, 1290, 1330, 1320, 900, 120, 50, 510, 50],
      [1500, 500, 10, 756, 10, 500, 18, 900, 403, 500, 10, 1000]
    ]
  };

  // 2. 指定配置和数据
  var option = {
    color: ["#c23531", "#2f4554", "#61a0a8", "#d48265" ], 
    tooltip: {
      // trigger with axis
      trigger: "axis"
    },
    legend: {
      left:"5%",
      right: "5%",
      textStyle: {
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
        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
        "10",
        "11",
        "12"
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
        name: "Data1",
        type: "line",
        stack: "Amount",
        smooth: true,
        data: data.year[0]
      },
      {
        name: "Data2",
        type: "line",
        stack: "Amount",
        smooth: true,
        data: data.year[1]
      },
      {
        name: "Data3",
        type: "line",
        stack: "Amount",
        smooth: true,
        data: data.year[2]
      },
      {
        name: "Data4",
        type: "line",
        stack: "Amount",
        smooth: true,
        data: data.year[3]
      }
    ]
  };
  // 3. 把配置和数据给实例对象
  myChart.setOption(option);

  // 重新把配置好的新数据给实例对象
  myChart.setOption(option);
  window.addEventListener("resize", function () {
    myChart.resize();
  });
})();

// pie chart function
(function () {
  // 基于准备好的dom，初始化echarts实例
  var myChart = echarts.init(document.querySelector(".pie .chart"));

  var option = {
    tooltip: {
        trigger: 'item',
        formatter: '{a} <br/>{b} : {c} ({d}%)'
    },
    legend: {
        orient: 'vertical',
        left: 'left',
        data: ['Data1', 'Data2', 'Data3', 'Data4', 'Data5']
    },
    series: [
        {
            type: 'pie',
            radius: '60%',
            center: ['60%', '40%'],
            data: [
                {value: 335, name: 'Data1'},
                {value: 310, name: 'Data2'},
                {value: 234, name: 'Data3'},
                {value: 135, name: 'Data4'},
                {value: 548, name: 'Data5'}
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
})();

// Radar chart
(function () {
  var myChart = echarts.init(document.querySelector(".radar .chart"));

  var option = {
    legend: {
        orient: 'vertical',
        left: 'left',
        data: ['Predicted Value','Actual Value']
    },
    tooltip: {
      // trigger with axis
      trigger: "item"
    },
    radar: [
        {

            indicator: [
                { text: 'Data1' },
                { text: 'Data2' },
                { text: 'Data3' },
                { text: 'Data4' },
                { text: 'Data5' }
            ],
            center: ['65%', '60%'],
            radius: 50,
            startAngle: 90,
            splitNumber: 4,
            shape: 'circle',
            name: {
                formatter: '{value}',
                textStyle: {
                    color: '#000000'
                }
            },
            splitArea: {
                areaStyle: {
                    color: ['rgba(114, 172, 209, 0.2)',
                        'rgba(114, 172, 209, 0.4)', 'rgba(114, 172, 209, 0.6)',
                        'rgba(114, 172, 209, 0.8)', 'rgba(114, 172, 209, 1)'],
                    shadowColor: 'rgba(0, 0, 0, 0.3)',
                    shadowBlur: 10
                }
            },
            axisLine: {
                lineStyle: {
                    color: 'rgba(255, 255, 255, 0.5)'
                }
            },
            splitLine: {
                lineStyle: {
                    color: 'rgba(255, 255, 255, 0.5)'
                }
            }
        },
    ],
    series: [
        {
            type: 'radar',
            emphasis: {
                lineStyle: {
                    width: 4
                }
            },
            data: [
                {
                    value: [100, 8, 0.40, -80, 2000],
                    name: 'Predicted Value',
                    symbol: 'rect',
                    symbolSize: 5,
                    lineStyle: {
                        type: 'dashed'
                    }
                },
                {
                    value: [60, 5, 0.30, -100, 1500],
                    name: 'Actual Value',
                    areaStyle: {
                        color: 'rgba(255, 255, 255, 0.5)'
                    }
                }
            ]
        }
    ]};
  myChart.setOption(option);
  window.addEventListener("resize", function () {
    myChart.resize();
  });
})();
