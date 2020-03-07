# LewisOODFinalProject

# When submitting your work, write a one or two paragraph description of your project, which design patterns you opted to use, where in your project they can be found, and the current status of the project. Mention what got finished and what is left to be done.

I made 'Task Tracker' a simple task tracking program, similar to Todoist in some aspects and Jira in others. I chose to use the Iterator, Singleton, Command, and State patterns. It can be found here in [the GitHub repo](https://github.com/zanewonsey/LewisOODFinalProject) I have for it. The project is complete for what I settled on for the scope at the beginning. I did cut things out of scope while designing it though. I might actual develop this further and actually use it so I am viewing this sort of like a initial 'sprint' creating a MVP.

Below are the packages the patterns are in

    Pattern     Package                       JUnit(me.wonsey.ood.tests)
    Iterator    me.wonsey.ood.containers      Yes
    Singleton   me.wonsey.ood.fileoperation   No
    Command     me.wonsey.ood.commands        Yes
    State       me.wonsey.ood.states          Yes
    
What got finished:
- Ability to add tasks to a list
- Each task has a completion status (waiting, in progress, complete)
- Ability to change completion status of a task
- Ability to add basic notes/details to each task
- Ability to save task list to a file
- Ability to read task list from a file
- Ability to remove task entirely
- Ability to filter the displayed tasks by completion status

What was left to be done is more so what was cut from scope at the beginning or had the specific implementation tweaked

Cut:
- Hotbar menu at the top with picture buttons for open file, save, save as, and exit
- Due dates for each task
- Help, about, and settings pop up menus 

Tweaked:
- I decided not to use timers so autosave ended up changing to requiring going in to the menu to save. I could have just put it in to my form update but decided it wasn't needed.
- I was going to give the user the ability to choose their own file name. Being able to use File->Save as or File->Open for example. I decided this added too much unnecessary complexity for the current 'sprint'.
- Decided I wouldn't use the remove() from my Iterable class and would just call the remove(T item) on the list itself

# **write up reflecting the challenges and difficulties you faced and how you learned from them**

The single biggest issue I ran in to was with trying to use a linked list with my iterator pattern. I thought it was going to be a simple thing and that a linked list would lend itself to being used with the Iterator Pattern. To my surprise the next() and hasNext() threw me through a loop (get it...loop...iterators....ha)  and I had to make a UML diagram to visualize how it was going to all fit together. I feel like this was a dumb thing to get stuck on but it really was a frustrating 6-7 hours for this one thing alone. I learned that I should probably get in the habit of using UML more often in the planning/design phase of my projects and new development.

Outside of the above frustration I feel like the rest of it went pretty well. Although, the sheer volume of topics I had to either learn from scratch or refamiliarize myself with was pretty daunting. I dealt with having to learn all of these topics by learning the gist of what they were for, designing the outline of what I wanted so I could split the topics up in to easy to test out portions, and slowly implementing each topic one by one and testing each component as I went. So I (roughly) went from implementing my linked list and testing it, then my iterator and testing that, then my singleton for file operations which with writeList(LinkedList<T> list) you would pass in the linked list and then it would get the iterator from the list and use the iterator to iterate over the list to write the (then strings, later tasks) to a file. While doing all of that I was learning about Generics, which I had only a passing knowledge of. The GUI was challenging because I had to learn new components I hadn't used before I learned how to use them with javadocs and stack overflow.

Another challenge was that this was the biggest project that I've had in this short of a time without a clearly defined scope from a senior engineer. In order to deal with this I defined the scope of what I wanted to do at the beginning and kept it realistic for the time frame I had.

fin