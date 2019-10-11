import React from 'react';
// import {Layout, Header, Footer, Menu, Content, Breadcrumb, Button, Row, Col} from 'antd'
import * as antd from 'antd'
import Grid from 'antd/lib/card/Grid';

import * as rest from './restRequest'

var Layout = antd.Layout, Menu = antd.Menu, Breadcrumb = antd.Breadcrumb;
var Header = Layout.Header, Content = Layout.Content, Footer = Layout.Footer;

const { Form, Icon, Button, Checkbox } = antd;

var Input = antd.Input;
var Search = Input.Search;

const { Card, Avatar } = antd;

const { Meta } = Card;

const {Row, Col} = antd;

const {List} = antd;

const baseUrl = 'http://127.0.0.1:8080/user'

class MainPage extends React.Component {
  render() {
    return (
      <Layout>
        <Header style={{ position: 'fixed', zIndex: 1, width: '100%' }}>
          <div className="logo" />
          <Menu
          theme="dark"
          mode="horizontal"
          defaultSelectedKeys={['2']}
          style={{ lineHeight: '64px' }}
          >
          <Menu.Item key="1">nav 1</Menu.Item>
          <Menu.Item key="2">nav 2</Menu.Item>
          <Menu.Item key="3">nav 3</Menu.Item>
          </Menu>
        </Header>
        <Content style={{ padding: '0 50px', marginTop: 64 }}>
            {/* <Breadcrumb style={{ margin: '16px 0' }}>
            <Breadcrumb.Item>Home</Breadcrumb.Item>
            <Breadcrumb.Item>List</Breadcrumb.Item>
            <Breadcrumb.Item>App</Breadcrumb.Item>
            </Breadcrumb> */}
            <div style={{paddingTop: 20}}>
              <Row type="flex" justify="center" align="middle" gutter={16}>
                <Col span={20}>
                  <UserList></UserList>
                </Col>
              </Row>
            </div>
        </Content>
        <Footer style={{ textAlign: 'center' }}>Ant Design ©2018 Created by Ant UED</Footer>
      </Layout>
    )
  }
}

class UserList extends React.Component {
  constructor(props) {
    super(props)
    this.state = {
      data: []
    }
  }

  loadUser() {
    rest.get(baseUrl).then(res => {
      this.setState({
        data: JSON.parse(res)
      })
    })
  }

  componentDidMount() {
    this.loadUser()
  }

  render() {
    return (
      <List
        itemLayout="horizontal"
        dataSource={this.state.data}
        renderItem={item => (
          <List.Item>
            <List.Item.Meta
              avatar={<Avatar src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png" />}
              title={<a href="https://ant.design">{item.username}</a>}
              description="Ant Design, a design language for background applications, is refined by Ant UED Team"
            />
            {item.email}
          </List.Item>
        )}
      />
    )
  }
}

// 卡片
class Panel extends React.Component {
  render() {
    return (
      <Card
        // style={{ width: 300 }}
        title="fsff"
        hoverable="true"
        cover={
          <img
            alt="example"
            src="https://gw.alipayobjects.com/zos/rmsportal/JiqGstEfoWAOHiTxclqi.png"
          />
        }
        actions={[
          <Icon type="setting" key="setting" title="hello"/>,
          <Icon type="edit" key="edit" />,
          <Icon type="ellipsis" key="ellipsis" />,
        ]}
      >
        <Meta
          avatar={<Avatar src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png" />}
          title="Card title"
          description="This is the description"
        />
      </Card>
    )
  }
}

class NormalLoginForm extends React.Component {
  handleSubmit = e => {
    e.preventDefault();
    this.props.form.validateFields((err, values) => {
      if (!err) {
        console.log('Received values of form: ', values);
      }
    });
  };

  render() {
    const { getFieldDecorator } = this.props.form;
    return (
      <Form onSubmit={this.handleSubmit} className="login-form">
        <Form.Item>
          {getFieldDecorator('username', {
            rules: [{ required: true, message: 'Please input your username!' }],
          })(
            <Input
              prefix={<Icon type="user" style={{ color: 'rgba(0,0,0,.25)' }} />}
              placeholder="Username"
            />,
          )}
        </Form.Item>
        <Form.Item>
          {getFieldDecorator('password', {
            rules: [{ required: true, message: 'Please input your Password!' }],
          })(
            <Input
              prefix={<Icon type="lock" style={{ color: 'rgba(0,0,0,.25)' }} />}
              type="password"
              placeholder="Password"
            />,
          )}
        </Form.Item>
        <Form.Item>
          {getFieldDecorator('remember', {
            valuePropName: 'checked',
            initialValue: true,
          })(<Checkbox>Remember me</Checkbox>)}
          <a className="login-form-forgot" href="">
            Forgot password
          </a>
          <Button type="primary" htmlType="submit" className="login-form-button">
            Log in
          </Button>
          Or <a href="">register now!</a>
        </Form.Item>
      </Form>
    );
  }
}

// 登录框
const WrappedNormalLoginForm = Form.create({ name: 'normal_login' })(NormalLoginForm);


// hello world
class HelloWorld extends React.Component {
  render() {
    return (
      <div>
        <h1>Hello, world!</h1>
        <h2>现在是 {this.props.date.toLocaleTimeString()}.</h2>
      </div>
    );
  }
}

// hello world 函数组件
function helloWorld(props) {
  return (
    <div>
      <h1>Hello, world!</h1>
      <h2>现在是 {props.date.toLocaleTimeString()}.</h2>
    </div>
  );
}

export default MainPage