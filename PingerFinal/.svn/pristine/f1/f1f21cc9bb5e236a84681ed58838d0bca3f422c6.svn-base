PingerViewModel = function(pinger, oConfig) {
	this.pinger = pinger;
	this.pinger.addListener(this);
	this.responseTime = ko.observable();
	this.processingTime = ko.observable();
	this.startTime = null;
	this.config = oConfig;
	showSpinner = ko.observable(false);
	showButton = ko.observable(true);
	setColor = ko.observable(0);
	message = ko.observable();
}
//inherits (PingerViewModel, PingListener);

PingerViewModel.prototype.press = function() {
	this.startTime = new Date().getTime();
	this.pinger.ping(this.config);
	showSpinner(true);
	showButton(false);
	setColor(0);
}
//------------------< PingListener callbacks >------------------
PingerViewModel.prototype.onSuccess = function(processingTime, successmessage) {
	this.responseTime("Response Time : " + (new Date().getTime() - this.startTime) + " ms ");
	this.processingTime("Processing Time : " + processingTime + " ms ");
	showSpinner(false);
	showButton(true);
	setColor(0);
	message("Status : " + successmessage);
};

PingerViewModel.prototype.onFailure = function(errormessage) {
	this.responseTime('');
	this.processingTime('');
	showSpinner(false);
	showButton(true);
	setColor(-1);
	message("Status : " + errormessage);
};

