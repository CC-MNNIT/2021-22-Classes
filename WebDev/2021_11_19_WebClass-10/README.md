# Web Development Class - X

## Web Development Class - X recording: [Here](https://drive.google.com/file/d/1uDngQh7DsCMoW216K4LMpDXIAp_XreM_/view?usp=sharing)

#### November 19, 2021

<div align="center"><img src="./images/react.png" alt="JS" height=150/></div>

<hr>

<div align="center"><h2>ReactJS (Continued)</h2></div>

* [CodeSandbox Link - Class-1](https://codesandbox.io/s/react-router-forked-s405f?file=/components/Topics.js)

* [CodeSandbox Link - React Router](https://codesandbox.io/s/react-router-forked-s405f?file=/components/Topics.js)

* ### **Functional Components (Hooks)**

    **What is a Hook?** 

    A Hook is a special function that lets you “hook into” React features. The main purpose of introducing hooks in react was to make function based components from stateless to state full.  It was introduced in React 16.8.

    * ***UseState***

        **What does calling `useState` do?** 

        - It declares a “state variable”.
        - `useState` is a new way to use the exact same capabilities that `this.state` provides in a class

        **What do we pass to `useState` as an argument?** 

        - The only argument to the `useState()` Hook is the initial state.

        **What does `useState` return?** 

        - It returns a pair of values: the current state and a function that updates it. This is similar to `this.state.count` and `this.setState` in a class, except you get them in a pair

        **Syntax**

        ```jsx
        const [ state, setState] = useState(<initial value>)
        ```

        **Reading State** 

        - Class-based Component

            ```jsx
            <p>You clicked {this.state.count} times</p>
            ```

        - Functional Components

            ```jsx
            <p>You clicked {count} times</p>
            ```

        **Updating State**

        - Class-based Component

            ```jsx
            <button onClick={() => this.setState({ 
                count: this.state.count + 1 
                })}>
                Click me
            </button>
            ```

        - Functional Component

            ```jsx
            <button onClick={() => setCount(count + 1)}>
                Click me
            </button>
            ```

        **Example:** [ReactJs Class - 1](https://codesandbox.io/s/ecstatic-germain-972lv?file=/src/Functional/UseStateHook.js)

    * ***UseEffect***

        The *Effect Hook* lets you perform side effects in function components. A common side effect is Data fetching (API calls).

        **What does `useEffect` do?**

        By using this Hook, you tell React that your component needs to do something after render. React will remember the function you passed (we’ll refer to it as our “effect”), and call it later after performing the DOM updates

        **What do we pass to `useEffect` as an argument?**

        ```jsx
        useEffect( function(){}, [<Dependency array>]);

        Note: Second argument i.e Dependency array is optional.
        ```

        **When does `useEffect` run?**

        By default, it runs both after the first render *and* after every update; if we do not pass the dependency array.

        So, here dependency array helps us to control when to run `useEffect`.

        **How to use dependency array?**

        **Running only at mount**

        Similarly, you can tell React to only execute the side effect once (at mount time), by passing an empty array

        ```jsx
        useEffect(() => {
            console.log(`Component mounted`)
        }, [])
        ```

        React will only re-run the side effect if one of the items in this array changes.

        ```jsx
        useEffect(() => {
            console.log(`Hi ${name} you clicked ${count} times`)
        }, [name, count])
        ```

        **Cleanup Function**

        A very common error that comes up in React

        `Can't perform a React state update on an unmounted component. This is a no-op, but it indicates a memory leak in your application. To fix, cancel all subscriptions and asynchronous tasks in a useEffect cleanup function`

        ```jsx
        function Example(props) {
            const [loading, setloading] = useState(true)

            useEffect(() => {
                let mounted = true
                fetchAPI.then(() => {
                    if (mounted) {
                        setloading(false)
                    }
                })

                return function cleanup() {
                    mounted = false
                }
            }, [])

            return <div>{loading ? <p>loading...</p> : <p>Fetched!!</p>}</div>
        }
        ```

    * ***UseRef***

        `useRef` is like a “box” that can hold a mutable value in its `.current` property.

        - When you want your information persists for the complete **lifetime of the component** you will go with **UseRef.**
        - `useRef` is useful when you want to track value change, but don't want to trigger re-render or `useEffect` by it.
        - Majorly it is use to keep the reference of the DOM elements.

        - Class-based Component

            ```jsx
            refContainer = createRef(initialValue);
            ```

        - Functional Component

            ```jsx
            const refContainer = useRef(initialValue);
            ```

        1. **Accessing the DOM nodes or React elements**
            
            - Functional Component
            
                ```jsx
                import React, { useRef } from "react";
                
                const CustomTextInput = () => {
                    const textInput = useRef();
                    
                    return (
                        <input type="text" ref={textInput} />
                    );
                }
                ```
            
            - Class-based Component
            
                ```jsx
                import React, { Component, createRef } from "react";
                
                class CustomTextInput extends Component {
                    textInput = createRef();
                    
                    render() {
                        return (
                            <input type="text" ref={this.textInput} />
                        );
                    }
                }
                ```
            

        1. **Keeping a mutable variable**
            
            ***Mutating the `.current` property doesn’t cause a re-render***
            
            ```jsx
            export default function LogButtonClicks() {
                const countRef = useRef(0);
                
                const handle = () => {
                    countRef.current++;
                    console.log(`Clicked ${countRef.current} times`);
                };
                console.log("I rendered!");
                return <button onClick={handle}>Click me</button>;
            }
            
            // Note: Why we can't use state to maintain the count of the number of re-renders ?
            ```
    

    * **UseState Vs UseRef**

        The common between them is, both `useState` and `useRef` can remember their data after re-renders. So if your variable is something that decides a **view layer render**, go with `useState`. Else use `useRef`

* ### **Functional Component Vs Class Based Component**

    **State is mutated in class-based components, but not in functional components**

    - Class-based component

        ```jsx
        class Example extends React.Component {
            // ... 
            componentDidMount() {
                document.title = `You clicked ${this.state.count} times`;
            }

            componentDidUpdate() {
                document.title = `You clicked ${this.state.count} times`;
            }

            render() {
                // ..  
            }
        }
        ```

    - Functional Component

        ```jsx
        function Example() {
            const [count, setCount] = useState(0);

                // Behave same as ComponentDidMount
            useEffect(() => {
                document.title = `You clicked ${count} times`;
            }, []);

                // Behave same as ComponentDidUpdate
                useEffect(() => {
                    document.title = `You clicked ${this.state.count} times`;
                }, [count]);

                // Here we one advantage that we are getting compare
                // to class based component is that we can merge
                // above to lifecycle methods in one.
                useEffect(() => {
                    document.title = `You clicked ${count} times`;
                }, [count]);

                // ... 
        }
        ```

    * **What should I use?**

        1. As React Documentation says - Prefer Functional component because optimisations will come in future (also it's much simpler, no more `this`)
        2. Class based will never become obsolete, its no harm to continue using them

* ### **Routing**

    * View this [GIF](https://b*log.logrocket.com/wp-content/uploads/2020/08/switchingbetweenhomeandabout.gif) to understand routing.

    * Till now we have been showing everything on the same url, but most of the websites show different content on different urls. For example - 

    * You see your profile page on a url like `example.com/profile` page

    * You see your bookmarks on a url like `[example.com/bookmarks](http://example.com/bookmarks)` page

    * [CodeSandbox Link for Routing](https://codesandbox.io/s/react-router-forked-s405f?file=/index.js)

    * To make routing possible in react we use [React Router](https://reactrouter.com/).

        ```jsx
        <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/about" element={<About />} />
        </Routes>
        ```

    * But remember React creates **Single-page Applications** so even if you see different routes (url) it is the same index.html page that is rendered

* ### **Links**

    * The concept of navigating between different web pages in HTML is to use an anchor tag:

        ```html
        <a href="">Some Link Name</a>
        ```

    * Using this approach in a React app is going to lead to refreshing a web page, each time a new view or page itself is rendered. This is not the advantage you are looking for when using a library like React. 

    * To avoid the refreshing of the web pages, the `react-router-dom` library provides the `Link` component. 

    * Here is how we will create a unique link to every blog post

        ```html
        <ul>
        {blogposts.map(post => (
            <li key={post.slug}>
            <Link to={`/posts/${post.slug}`}>
                <h3>{post.title}</h3>
            </Link>
            </li>
        ))}
        </ul>
        ```

### **Content Contributors** 
* [Harshit Gangwar](https://github.com/harshjoeyit)
* [Aman Tibrewal](https://github.com/amantibrewal310)

### Resources

- [Understanding Functional Components vs. Class Components in React](https://www.twilio.com/blog/react-choose-functional-components)
- [The Complete Guide to useRef() and Refs in React](https://dmitripavlutin.com/react-useref-guide/)
- [React useEffect cleanup: How and when to use it](https://dev.to/otamnitram/react-useeffect-cleanup-how-and-when-to-use-it-2hbm)
- [A Complete Guide to useEffect](https://overreacted.io/a-complete-guide-to-useeffect/)
- [99% React Developers Fail to Answer THIS Question!](https://www.youtube.com/watch?v=JxzzpDHYYXk)
- [A guide to using React Router v6 in React apps - LogRocket Blog](https://blog.logrocket.com/react-router-v6/)
- [React Router v6 in depth guide](https://www.youtube.com/watch?v=0cSVuySEB0A&ab_channel=HiteshChoudhary)