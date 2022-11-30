function lock() {

				document.getElementById("time").innerHTML = getDate();

			}

			function week() {

				var day = new Date;

				var weekday = new Array(7);

				weekday[0] = "星期天";

				weekday[1] = "星期一";

				weekday[2] = "星期二";

				weekday[3] = "星期三";

				weekday[4] = "星期四";

				weekday[5] = "星期五";

				weekday[6] = "星期六";

				// document.getElementById("week").innerHTML = weekday[day.getDay()];
				return weekday[day.getDay()];
				// console.log(document.getElementById("week"));



			}

			function getDate() {

				var time = new Date();

				var year = time.getFullYear();

				var month = time.getMonth() + 1;

				if (month <= 9) {

					month = "0" + month

				}

				var strdate = time.getDate();

				if (strdate <= 9) {

					strdate = "0" + strdate

				}

				var hour = time.getHours();

				if (hour <= 9) {

					hour = "0" + hour

				}

				var min = time.getMinutes();

				if (min <= 9) {

					min = "0" + min

				}

				var second = time.getSeconds();

				if (second <= 9) {

					second = "0" + second

				}

				var str = year + "/" + month + "/" + strdate + " " + hour + ":" + min + ":" + second + " " + week();

				// console.log(str);

				return str;

			}
