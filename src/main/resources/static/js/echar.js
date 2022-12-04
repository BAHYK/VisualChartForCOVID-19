function mc(result) {

	let list = [];
	for (let i of result){
		let mp = {};
		map.set(i.provinceName,[i.nowConfirm,i.confirm,i.dead])
		mp['name'] = i.provinceName;
		mp['value'] = i.nowConfirm;
		list.push(mp);
	}

				function randomData() {

					return Math.round(Math.random() * 1200);
				}
				var mydata = list;

				var option = {
					title: {
						text: '全国疫情风险地图',

						x: 'center',
						textStyle: {
							fontSize: 32, //字体大小
							color: '#ffffff'
						},

					},
					tooltip: {
						padding: 0,
						enterable: true,
						transitionDuration: 0,
						textStyle: {
							color: '#ffffff',
							decoration: 'none',
						},
						extraCssText: 'white-space:pre-wrap',
						formatter: function(params) {
							let nameX = params.name
							// var index = $(params);
							let values = map.get(nameX)
							return `<div style="width: 200px;height: 200px;padding: 0;text-align: center;font-size:18px;">
										<span>${nameX}</span>
										<span>现存病例：${values[0]}</span>
										<span>治愈病例：${values[1]}</span>
										<span>死亡病例：${values[2]}</span>
									</div>`
						}
					},
					visualMap: {
						show: true,
						type: 'piecewise', //piecewise continuous
						splitList: [{
							end: 1
						}, {
							start: 1,
							end: 500
						}, {
							start: 501,
							end: 1000
						}, {
							start: 1000,
						}],
						color: ['#CC0000', '#FF0033', '#CCFF00', '#00FF00'],
						textStyle: {
							color: '#ffffff'
						},
					},
					geo: {
						map: 'china',
						show: true,
						roam: false,
						zoom: 1.3,
						aspectScale: 0.8,
						layoutCenter: ["50%", "50%"],
						layoutSize: '85%',

						label: {
							normal: {
								show: true,
								fontSize: '16',
								color: '#ffffff'
							},
							emphasis: {
								color: '#ffffff',
							},
						},
						regions: [{
							name: '南海诸岛',
							itemStyle: {
								areaColor: 'rgb(17,37,76)',
								borderColor: 'rgb(17,37,76)',
								normal: {
									opacity: 0,
									label: {
										show: false,
										color: "#000000",
									},
								},
							},
							llabel: {
								show: false,
								color: '#000000',
								fontSize: 12,
							},
						}],
						itemStyle: {
							normal: {
								shadowColor: 'rgba(80,225,247,0.6)',
								shadowOffsetX: 1,
								shadowOffsetY: 4,
								opacity: 1,
								shadowBlur: 10
							},
							emphasis: {
								areaColor: 'rgba(0, 170, 255, 1.0)',
							}
						},
					},
					legend: {
						textStyle: {
							color: 'rgb(255,255,255,0.9)'
						}
					},
					series: [{
						name: '疫情数据',
						type: 'map',
						mapType: 'china',
						geoIndex: 0,
						data: mydata
					}],
				};
				var chart = echarts.init(document.getElementById('maincenter'));
				chart.setOption(option);
			}