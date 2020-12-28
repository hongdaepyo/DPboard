var main = {
	init : function() {
		var _this = this;
		this.getBoardList();
	},
	getBoardList : function() {
		var _this = this;
		$.ajax({
			method: "GET",
			url: "/board/all",
			success: function(result) {
				console.log(result);
			},
			error: function() {
				alert("오류가 발생했습니다.");
			}
		})
	}
}

main.init();