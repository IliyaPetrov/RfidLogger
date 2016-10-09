var node_dir = __dirname + '/node_modules';

module.exports = {
  entry: [
    './app/index.js'
  ],
  output: {
    path: __dirname,
    publicPath: '/',
    filename: 'bundle.js'
  },
  module: {
    loaders: [{
      exclude: /node_modules/,
      loader: 'babel'
    }]
  },
  resolve: {
    extensions: ['', '.js', '.jsx'], 
	alias: { 'stompjs': node_dir + '/stompjs/lib/stomp.js' }
  },
  devServer: {
    contentBase: './'
  }
};
