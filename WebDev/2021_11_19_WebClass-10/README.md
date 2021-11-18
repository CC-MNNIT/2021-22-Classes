# Web Development Class - X

#### November 19, 2021

<div align="center"><img src="./images/react.png" alt="JS" height=150/></div>

<hr>

<div align="center"><h2>ReactJS</h2></div>

* ### **Functional Components (Hooks)**

    * **What is a Hook?**

        A Hook is a special function that lets you “hook into” React features. The main purpose of introducing hooks in react was to make function based components from stateless to state full

    * **_UseState_**

        **What does calling `useState` do?**

        - It declares a “state variable”.
        - `useState` is a new way to use the exact same capabilities that `this.state` provides in a class

        **What do we pass to `useState` as an argument?**

        - The only argument to the `useState()` Hook is the initial state.

        **What does `useState` return?**

        - It returns a pair of values: the current state and a function that updates it. This is similar to `this.state.count` and `this.setState` in a class, except you get them in a pair

        **Syntax**

        ```jsx
        const [ set, setState] = useState(<initial value>)
        ```

    * **Reading State**

        * Class-based Component

            ```jsx
            <p>You clicked {this.state.count} times</p>
            ```

        * Functional Components

            ```jsx
            <p>You clicked {count} times</p>
            ```

    * **Updating State**

        * Class-based Component

            ```jsx
            <button
                onClick={() =>
                    this.setState({
                    count: this.state.count + 1,
                    })
                }
            >
                Click me
            </button>
            ```

        * Functional Component

            ```jsx
            <button onClick={() => setCount(count + 1)}>Click me</button>
            ```

        * **Example:** Visit [this](https://codesandbox.io/s/ecstatic-germain-972lv?file=/src/Functional/UseStateHook.js) for example.

    * **_UseEffect_**

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

        React will only re-run the side effect if one of the items in this array changes.

        ```jsx
        useEffect(() => {
            console.log(`Hi ${name} you clicked ${count} times`);
        }, [name, count]);
        ```

        **Running only at mount**

        Similarly, you can tell React to only execute the side effect once (at mount time), by passing an empty array

        ```jsx
        useEffect(() => {
            console.log(`Component mounted`);
        }, []);
        ```

        **Example**

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

### **Content Contributors** 
* [Aman Tibrewal](https://github.com/amantibrewal310)
* [Harshit Gangwar](https://github.com/harshjoeyit)