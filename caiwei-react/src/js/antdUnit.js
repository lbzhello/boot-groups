import React from 'react';
// import {Layout, Header, Footer, Menu, Content, Breadcrumb, Button, Row, Col} from 'antd'
import * as antd from 'antd'
import Grid from 'antd/lib/card/Grid';

import * as rest from './restRequest'

var Layout = antd.Layout, Menu = antd.Menu, Breadcrumb = antd.Breadcrumb;
var Header = Layout.Header, Content = Layout.Content, Footer = Layout.Footer;

const {Form, Icon, Button, Checkbox} = antd;

var Input = antd.Input;
var Search = Input.Search;

const {Card, Avatar} = antd;

const {Meta} = Card;

const {Row, Col} = antd;

const {List} = antd;

const baseUrl = 'http://127.0.0.1:8080/users'

class MainPage extends React.Component {
    render() {
        return (
            <Layout>
                <Header style={{position: 'fixed', zIndex: 1, width: '100%'}}>
                    <div className="logo"/>
                    <Navbar></Navbar>
                </Header>
                <Content style={{padding: '0 50px', marginTop: 64}}>
                    <div style={{paddingTop: 20}}>
                        <Row type="flex" justify="center" align="middle" gutter={16}>
                            <Col span={24}>
                                <NewsList></NewsList>
                            </Col>
                        </Row>
                    </div>
                </Content>
                <Footer style={{textAlign: 'center'}}>Ant Design ©2018 Created by Ant UED</Footer>
            </Layout>
        )
    }
}

class Navbar extends React.Component {
    render() {
        return (
            <Menu
                theme="dark"
                mode="horizontal"
                selectable={false}
                style={{lineHeight: '64px'}}
            >
                <Avatar src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png"
                        size={"large"}
                        style={{ backgroundColor: '#ffffff', marginRight: 20 }}
                />
                <Search
                    placeholder="input search text"
                    onSearch={value => console.log(value)}
                    style={{width: 250}}
                />
                <Menu.Item key="1" onClick={e => console.log(e)}><Icon type="home"/>主页</Menu.Item>
                <Menu.Item key="2"><Icon type="fire"/>热点</Menu.Item>
                <Menu.Item key="3"><Icon type="plus"/>发布</Menu.Item>
                <Menu.SubMenu
                    key="4"
                    title={
                        <span className="submenu-title-wrapper">
                            <Icon type="setting" />
                            setting
                        </span>
                    }

                    style={{float: "right"}}
                >
                    <Menu.ItemGroup title="Item 1">
                        <Menu.Item key="setting:1">Option 1</Menu.Item>
                        <Menu.Item key="setting:2">Option 2</Menu.Item>
                    </Menu.ItemGroup>
                    <Menu.ItemGroup title="Item 2">
                        <Menu.Item key="setting:3">Option 3</Menu.Item>
                        <Menu.Item key="setting:4">Option 4</Menu.Item>
                    </Menu.ItemGroup>
                </Menu.SubMenu>
            </Menu>
        )
    }
}

class NewsList extends React.Component {
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
        let users = this.state.data
        const IconText = ({type, text}) => (
            <span>
                <Icon type={type} style={{marginRight: 8}}/>
                {text}
            </span>
        )

        return (
            <List
                itemLayout="vertical"
                dataSource={users}
                pagination={{
                    onChange: page => {
                        console.log(page);
                    },
                    pageSize: 5,
                    position: "bottom",
                    hideOnSinglePage: true
                }}
                renderItem={item => (
                    <List.Item
                        key={item.title}
                        actions={[
                            <IconText type="star-o" text={item.star || 0} key="list-vertical-star-o"/>,
                            <IconText type="like-o" text={item.like || 0} key="list-vertical-like-o"/>,
                            <IconText type="message" text={item.comments || 0} key="list-vertical-message"/>,
                        ]}
                        extra={
                            <img
                                width={272}
                                alt="logo"
                                src="https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png"
                            />
                        }
                    >
                        <List.Item.Meta
                            avatar={<Avatar src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png"/>}
                            title={<a href="https://ant.design">{item.username}</a>}
                            description="last 2 minutes ago"
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
                    <Icon type="edit" key="edit"/>,
                    <Icon type="ellipsis" key="ellipsis"/>,
                ]}
            >
                <Meta
                    avatar={<Avatar src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png"/>}
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
        const {getFieldDecorator} = this.props.form;
        return (
            <Form onSubmit={this.handleSubmit} className="login-form">
                <Form.Item>
                    {getFieldDecorator('username', {
                        rules: [{required: true, message: 'Please input your username!'}],
                    })(
                        <Input
                            prefix={<Icon type="user" style={{color: 'rgba(0,0,0,.25)'}}/>}
                            placeholder="Username"
                        />,
                    )}
                </Form.Item>
                <Form.Item>
                    {getFieldDecorator('password', {
                        rules: [{required: true, message: 'Please input your Password!'}],
                    })(
                        <Input
                            prefix={<Icon type="lock" style={{color: 'rgba(0,0,0,.25)'}}/>}
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
const WrappedNormalLoginForm = Form.create({name: 'normal_login'})(NormalLoginForm);


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