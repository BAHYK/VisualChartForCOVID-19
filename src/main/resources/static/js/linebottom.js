function lb() {
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
						bottom: "10%",
						containLabel: true
					},
					yAxis: {

						data: ["衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋",'黎静华','黎静华','黎静华','黎静华','黎静华'],
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
							show: false,
							textStyle: {
								color: "#ffffff"
							}
						}
					},
					series: [{
						name: '销量',
						type: 'bar',
						data: [5, 20, 36, 10, 10],
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
