Pinger = function() {
	this.processingTime = null;
	this.message = null;
	this.listener = null;
}

Pinger.prototype._defaults = function() {
	return {
		timeout : 5000,
		url : "RequestServlet"
	};
};

Pinger.prototype.addListener = function(listener) {
	this.listener = listener;
}

Pinger.prototype.ping = function(oConfig) {
	var config = oConfig || this._defaults();
	var self = this;
	var ajaxUrl = config.url;

	$.ajax({
		type : "GET",
		url : ajaxUrl,
		success : function(result) {
			self.processingTime = result.processingTime;
			self.message = "Success & Resource avaliable";
			self.listener.onSuccess(self.processingTime, self.message);
		},
		error : function(requestTimeout) {
			if (requestTimeout == "timeout") {
				self.processingTime = requestTimeout;
				self.message = "Error & Request Timed out";
			} else {
				self.processingTime = 0;
				self.message = "Error & Web Resource Unavailable";
			}
			self.listener.onFailure(self.message);
		},
		timeout : config.timeout,
	});

}

