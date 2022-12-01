function mc(result) {
	console.log(result)



	let map = new Map();
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
				// var mydata = [{
				// 	name: '内蒙古',
				// 	value: {v1:123,v2:'456'}
					/*, {
						name: '天津',
						value: randomData()
					},
					{
						name: '上海',
						value: randomData()
					}, {
						name: '重庆',
						value: randomData()
					},
					{
						name: '河北',
						value: randomData()
					}, {
						name: '河南',
						value: randomData()
					},
					{
						name: '云南',
						value: randomData()
					}, {
						name: '辽宁',
						value: randomData()
					},
					{
						name: '黑龙江',
						value: randomData()
					}, {
						name: '湖南',
						value: randomData()
					}, {
						name: '安徽',
						value: randomData()
					}, {
						name: '山东',
						value: randomData()
					},
					{
						name: '新疆',
						value: randomData()
					}, {
						name: '江苏',
						value: randomData()
					},
					{
						name: '浙江',
						value: randomData()
					}, {
						name: '江西',
						value: randomData()
					},
					{
						name: '湖北',
						value: randomData()
					}, {
						name: '广西',
						value: randomData()
					},
					{
						name: '甘肃',
						value: randomData()
					}, {
						name: '山西',
						value: randomData()
					},
					{
						name: '内蒙古',
						value: randomData()
					}, {
						name: '陕西',
						value: randomData()
					},
					{
						name: '吉林',
						value: randomData()
					}, {
						name: '福建',
						value: randomData()
					},
					{
						name: '贵州',
						value: randomData()
					}, {
						name: '广东',
						value: randomData()
					},
					{
						name: '青海',
						value: randomData()
					}, {
						name: '西藏',
						value: randomData()
					},
					{
						name: '四川',
						value: randomData()
					}, {
						name: '宁夏',
						value: randomData()
					},
					{
						name: '海南',
						value: randomData()
					}, {
						name: '台湾',
						value: randomData()
					},
					{
						name: '香港',
						value: randomData()
					}, {
						name: '澳门',
						value: randomData()
					}*/
				// ];

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
							return `<div style="width: 180px;height: 180px;padding: 0;text-align: center;font-size:20px;">
										<span>${nameX}</span>
										<span>现存病例：${values[0]}</span>
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
						roam: true,
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