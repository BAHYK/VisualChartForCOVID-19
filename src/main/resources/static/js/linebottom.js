function lb() {
    let namel = []
    let valuel = []
    let namelt = []
    let valuelt = []

    for (let key of map.keys()) {
        namel.push(key)
        valuel.push(parseInt(map.get(key)[0]))
    }


    for (let i = 0; i < valuel.length; i++) {
        for (let j = 0; j < i; j++) {
            if (valuel[i] < valuel[j]) {
                let tmp = valuel[i];
                valuel[i] = valuel[j];
                valuel[j] = tmp;
                let tmp1 = namel[i];
                namel[i] = namel[j];
                namel[j] = tmp1;

            }
        }
    }
    for (let i = 24 ; i < 34 ; i++){
        namelt.push(namel[i]);
        valuelt.push(valuel[i])
    }
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('linebottom'));
    // 指定图表的配置项和数据
    var option = {
        //title是用于定义图片标题的,里面有很多属性可以配置,详细属性项可查看文档
        tooltip: {},
        grid: {
            left: "5%",
            top: "4%",
            right: "10%",
            bottom: "30%",
            containLabel: true
        },
        yAxis: {
            data: namelt,
            splitLine: {
                show: false,
                textStyle: {
                    color: "#ffffff"
                }
            },
            axisLabel: {
                show: true,
                //右侧Y轴文字显示
                textStyle: {
                    color: "#ffffff",
                    fontSize: 14
                }
            },
        },
        xAxis: {
            type: "value",
            name: "人数",
            splitLine: {
                show: true,
                textStyle: {
                    color: "#ffffff"
                }
            },
            axisLabel: {
                show: true,
                //右侧Y轴文字显示
                textStyle: {
                    color: "#ffffff",
                    fontSize: 14
                }
            },
        },
        series: [{
            name: '确诊人数',
            type: 'bar',
            data: valuelt,
            barWidth: '20%',
            itemStyle: {
                normal: {
                    label: {
                        show: true, // 开启显示
                        distance: 10, // 条柱之间的距离
                        position: 'right', // 在上方top在右侧right显示
                        textStyle: { // 数值样式
                            color: '#ffffff',
                            fontSize: 14
                        }
                    }
                }
            }

        }]
    };
    // 使用指定的配置项和数据显示图表。
    myChart.setOption(option);
}
