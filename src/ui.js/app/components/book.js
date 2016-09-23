import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import classNames from 'classnames';

import { connect } from 'react-redux';
import { selectBook } from '../actions/select_book';
import { bindActionCreators } from 'redux';


class Book extends Component{
	constructor(props) {
    super(props);
		}

	 render() {
		return (
			<tr>
				<td>{this.props.bookProp.entrance}</td>
				<td>{this.props.bookProp.name}</td>
				<td>{this.props.bookProp.exit}</td>
			</tr>
		)
	}
}


function mapDispatchToProps(dispatch) {
  return bindActionCreators({ selectBook }, dispatch);
}

export default connect(null , mapDispatchToProps)(Book);
