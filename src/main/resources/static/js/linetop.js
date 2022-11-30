function lt() {
				option = {
					color: ['#ff0000', '#d5d5d5', '#00ff00'],
					tooltip: {
						trigger: 'axis'
					},
					grid: {
						top: '10%',
						left: '0%',
						right: '10%',
						bottom: '20%',
						containLabel: true
					},
					xAxis: {
						name: '日期',
						type: 'category',
						data: datas,
						axisLine: {
							show: true,
							lineStyle: {
								color: 'rgba(255, 255, 255, 1.0)'
							}
						},
						boundaryGap: true, // 坐标两侧是否留白
						axisTick: {
							show: false // 是否显示刻度线
						}
					},
					yAxis: [{
							type: 'value',
							axisLabel: {
								color: '#ffffff', // y 轴文字颜色
								formatter: '{value}'
							},
							axisLine: {
								show: true,
								lineStyle: {
									color: '#E6E6FA' // y 轴轴线颜色
								}
							},
							splitLine: {
								lineStyle: {
									color: '#FFDEAD', //grid 区域中的分隔线颜色
									width: 1,
									type: 'solid'
								}
							}
						},
						{
							type: 'value',
							name: '人数',
							position: 'left',
							alignTicks: false,
							nameGap: 8,
							axisLine: {
								show: true, // 是否显示 y 轴轴线
								lineStyle: {
									color: 'rgba(255, 255, 255, 1.0)'
								},
							},
						}
					],
					legend: {
						orient: 'horizontal', //布局方式：  horizontal/vertical
						x: 'center', // 水平安放位置，默认为全图居中，可选： 'center' ¦ 'left' ¦ 'right'  或 {number}（x坐标，单位px）
						y: 'top', //垂直安放位置，默认为全图顶端，可选： 'top' ¦ 'bottom' ¦ 'center' 或 {number}（y坐标，单位px）
						textStyle: {
							fontSize: 16,
							color: ['#ff0000', '#d5d5d5', '#00ff00']
						},
						data: ['累计确诊病例', '累计死亡病例', '累计治愈病例']
					},
					series: [{
							type: 'line',
							name: '累计确诊病例',
							symbolSize: 8,
							data: ['74', '99', '84', '75', '86', '74', '53','251'],
						},
						{
							type: 'line',
							name: '累计死亡病例',
							symbolSize: 8,
							data: ['80', '120', '840', '750', '860', '740', '530','451'],
						},
						{
							type: 'line',
							name: '累计治愈病例',
							symbolSize: 8,
							data: ['800', '125', '840', '175', '600', '740', '253','124'],
						},
					]
				};
				let myechart = echarts.init(document.getElementById('linetop'));
				myechart.setOption(option);
			}