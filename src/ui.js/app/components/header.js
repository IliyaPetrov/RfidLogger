import React, { Component } from 'react';
import classNames from 'classnames';
import { connect } from 'react-redux';
import { sortBy } from '../actions/sort';
import { bindActionCreators } from 'redux';
import { fetchWeather } from '../actions/index';
import { searchAction } from '../actions/search';

import * as config from '../config';

class Header extends Component{
  constructor(props) {
		super(props);
		this.state = {sortClass: true, sortByNameAsc: true, searchTerm: ''};
		this.sortByName = this.sortByName.bind(this);
    this.searchByName = this.searchByName.bind(this);
    this.alterIcon = this.alterIcon.bind(this);
		}


    sortByName(field){
      if(!this.state.sortByNameAsc){
        this.props.sortBy(field.concat(",asc"));
        this.props.fetchWeather(this.props.setPageSize,config.DEFALT_PAGE_NUMBER,field.concat(",asc"));
      } else {
        this.props.sortBy(field.concat(",desc"));
        this.props.fetchWeather(this.props.setPageSize,config.DEFALT_PAGE_NUMBER,field.concat(",desc"));
      }
      this.alterIcon(field);
    }

    searchByName(field){
      this.props.searchAction(field.target.value);
    }

    alterIcon(field){
      if (field == "author"){
        this.setState({sortClass: !this.state.sortClass});
        this.setState({sortByNameAsc: !this.state.sortByNameAsc});
      }
    }

  render() {
    var sortClass = classNames({
      'glyphicon glyphicon-sort-by-attributes-alt spanIcon glyphiconSize': !this.state.sortClass,
      'glyphicon glyphicon-sort-by-attributes spanIcon glyphiconSize': this.state.sortClass
    });

  return (
        <tr>
            <th>
                <div className="col-xs-6">
                  <h4>Вход</h4>
                </div>
            </th>
            <th>
                <div className="col-xs-6">
                <h4>Име</h4>
                </div>
            </th>
            <th>
                <div className="col-xs-6">
                <h4>Изход</h4>
                </div>
            </th>
        </tr>
  )
}
}

function mapStateToProps({ setPageSize }) {
  return { setPageSize };
}


function mapDispatchToProps(dispatch) {
  return {
    sortBy: bindActionCreators(sortBy, dispatch),
    fetchWeather: bindActionCreators(fetchWeather, dispatch),
    searchAction: bindActionCreators(searchAction, dispatch)
  }
}

export default connect(mapStateToProps, mapDispatchToProps)(Header);
