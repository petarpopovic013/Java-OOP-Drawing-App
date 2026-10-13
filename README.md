# 🎨 Java Swing Drawing Application

### Interactive 2D Drawing Application | Object-Oriented Programming in Java

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Swing](https://img.shields.io/badge/Java_Swing-007396?style=for-the-badge&logo=java&logoColor=white)
![OOP](https://img.shields.io/badge/Object--Oriented-Programming-blue?style=for-the-badge)
![GitHub](https://img.shields.io/badge/Git-GitHub-181717?style=for-the-badge&logo=github)

## 📖 Overview

**Java Swing Drawing Application** is a desktop application developed using Java, Swing, and AWT.

The project demonstrates fundamental object-oriented programming principles through an interactive graphical interface that allows users to create, select, modify, and delete two-dimensional geometric shapes.

In addition to the drawing application, the project includes two complementary modules demonstrating fundamental data structure operations:

- **Drawing** — Interactive creation and manipulation of geometric shapes.
- **Stack** — Implementation of Last-In-First-Out (LIFO) operations.
- **Sort** — Sorting geometric objects based on their calculated areas.

The project was developed as part of the **Object-Oriented Information Technologies** course at the Faculty of Technical Sciences, University of Novi Sad.

---

## ✨ Key Features

### 🎨 1. Interactive Drawing

Users can create five types of geometric shapes directly on a drawing canvas.

| Shape | Description |
|-------|-------------|
| Point | Creates a point at the selected coordinates |
| Line | Connects two points selected through consecutive clicks |
| Rectangle | Creates a rectangle using position, width, and height |
| Circle | Creates a circle using center coordinates and radius |
| Donut | Creates a ring-shaped object using inner and outer radii |

Each shape is represented by a dedicated Java class containing its geometric properties and drawing behavior.

The application uses mouse events to capture coordinates and dynamically render shapes on the canvas.

### 🖱️ 2. Shape Selection

The application supports interactive shape selection through mouse clicks.

Selection behavior includes:

- Selecting a shape by clicking on it.
- Deselecting an already selected shape.
- Selecting only one shape at a time.
- Automatically deselecting shapes when clicking on an empty area.
- Prioritizing the most recently drawn shape when multiple shapes overlap.

The selection mechanism uses geometric hit detection to determine whether a mouse click intersects a particular shape.

### ✏️ 3. Shape Modification

Existing shapes can be modified through dedicated modal dialog windows.

Depending on the selected shape, users can modify:

- X and Y coordinates
- Width and height
- Circle radius
- Donut inner and outer radii
- Outline color
- Fill color

Each dialog is initialized with the selected shape's current properties.

Changes are applied to the existing object, preserving its reference within the application's shape collection.

Users can also cancel the modification without changing the original object.

### 🗑️ 4. Shape Deletion

The application provides controlled deletion of selected shapes.

The deletion workflow includes:

1. Selecting a geometric shape.
2. Clicking the Delete button.
3. Displaying a confirmation dialog.
4. Removing the shape only after user confirmation.
5. Refreshing the drawing canvas.

This prevents accidental deletion and demonstrates event-driven interaction with Java Swing components.

### 🌈 5. Color Customization

Users can customize the visual appearance of geometric shapes through Java's built-in `JColorChooser`.

Supported options include:

- Custom outline colors
- Custom fill colors for applicable shapes
- Color modification after shape creation

Color information is stored within the shape objects and used during rendering.

### 🛡️ 6. Input Validation

The application includes input validation and error handling.

Validation covers:

- Empty input fields
- Invalid numeric values
- Negative or otherwise invalid dimensions
- Invalid radius combinations
- Operations without a selected shape

Invalid operations are handled through user-friendly `JOptionPane` messages.

---

## 🧱 Additional Modules

### 📚 Stack Application

The Stack module demonstrates the **Last-In-First-Out (LIFO)** data structure using Donut objects.

Users can:

- Create Donut objects.
- Specify center coordinates and radii.
- Push objects onto a stack.
- View stack contents through a Swing `JList`.
- Pop the most recently added object.
- Review object properties before removal.
- Confirm or cancel removal operations.

#### LIFO Principle

The last element inserted into the stack is the first element removed.

Example:

```text
Push Donut A
Push Donut B
Push Donut C

Stack:

TOP → Donut C
      Donut B
      Donut A

Pop() → Donut C
```

This module demonstrates fundamental stack operations and their integration into a graphical user interface.

### 📊 Sort Application

The Sort module demonstrates object comparison and sorting using geometric properties.

Users can:

- Create multiple Donut objects.
- Add objects to a Swing `JList`.
- Calculate the area of each Donut.
- Sort objects by area in descending order.

#### Donut Area Calculation

The area of a Donut is calculated using:

```text
A = π × (R² - r²)
```

Where:

- `A` = Donut area
- `R` = Outer radius
- `r` = Inner radius

The sorting operation arranges objects from the largest area to the smallest.

Example:

```text
Before sorting:

Donut A → Area: 150
Donut B → Area: 320
Donut C → Area: 210

After sorting:

Donut B → Area: 320
Donut C → Area: 210
Donut A → Area: 150
```

This module demonstrates sorting objects based on calculated numerical properties.

---

## 🏗️ Architecture

The application separates geometric models from graphical user interface components.

### Geometry Layer

Contains the classes responsible for representing and manipulating geometric objects.

Core classes include:

- `Shape`
- `Point`
- `Line`
- `Rectangle`
- `Circle`
- `Donut`

Each class encapsulates the properties and behavior associated with its corresponding geometric shape.

### GUI Layer

Contains the components responsible for user interaction and rendering.

Important components include:

| Component | Responsibility |
|-----------|----------------|
| `DrawingApp` | Application entry point |
| `FrmDrawing` | Main application window |
| `PnlDrawing` | Drawing canvas and rendering |
| `DlgPoint` | Point properties dialog |
| `DlgLine` | Line properties dialog |
| `DlgRectangle` | Rectangle properties dialog |
| `DlgCircle` | Circle properties dialog |
| `DlgDonut` | Donut properties dialog |

### Application Workflow

```text
                 USER
                   |
                   v
           +---------------+
           |   FrmDrawing  |
           |  Main Window  |
           +---------------+
                   |
                   v
           +---------------+
           | Mouse Events  |
           | GUI Actions   |
           +---------------+
                   |
          +--------+--------+
          |                 |
          v                 v
  +---------------+  +---------------+
  | Dialog Input  |  | Shape         |
  | Validation    |  | Selection     |
  +---------------+  +---------------+
          |                 |
          +--------+--------+
                   |
                   v
           +---------------+
           | Shape Objects |
           | Geometry      |
           +---------------+
                   |
                   v
           +---------------+
           |  PnlDrawing   |
           | Rendering     |
           +---------------+
                   |
                   v
              GUI UPDATE
```

This separation keeps the geometric logic independent of the user interface.

---

## 🧠 Object-Oriented Programming Concepts

The project demonstrates several fundamental OOP concepts.

### 1. Encapsulation

Each geometric object manages its own properties, including coordinates, dimensions, colors, and selection state.

These properties are accessed and modified through the corresponding class methods.

### 2. Inheritance

The application uses inheritance to establish relationships between geometric shapes.

For example, the `Donut` class extends the functionality of the `Circle` class by introducing an additional inner radius.

This allows common geometric behavior to be reused instead of duplicated.

### 3. Polymorphism

Different geometric shapes share common operations while providing their own implementations.

For example, each shape implements its own drawing behavior through a `draw(Graphics g)` method.

The drawing panel can therefore iterate through a collection of shapes and render each object through a common interface.

Conceptual example:

```java
for (Shape shape : shapes) {
    shape.draw(g);
}
```

This makes the application easier to extend with additional geometric shapes.

### 4. Abstraction

The `Shape` class provides a common abstraction for geometric objects.

Shared behavior is defined at a higher level, while individual shape classes implement their specific geometry and rendering logic.

### 5. Event-Driven Programming

The application uses Java Swing event listeners to respond to user actions.

Examples include:

- Mouse clicks
- Button presses
- Dialog confirmations
- Shape selection
- Color selection

This enables an interactive desktop application where the interface reacts dynamically to user input.

---

## 🔧 Technologies Used

| Technology | Purpose |
|------------|---------|
| Java | Core application development |
| Java Swing | Desktop GUI development |
| Java AWT | Graphics rendering and event handling |
| Collections Framework | Managing geometric objects |
| ArrayList | Storing and accessing shapes |
| JList | Displaying Stack and Sort elements |
| JDialog | Custom modal input dialogs |
| JOptionPane | Error messages and confirmations |
| JColorChooser | Interactive color selection |
| Git | Version control |
| GitHub | Source code management |

---

## 📁 Project Structure

The project is organized around separate packages for geometry and graphical interfaces.

```text
Java-Drawing-Application/
│
├── src/
│   │
│   ├── geometry/
│   │   ├── Shape.java
│   │   ├── Point.java
│   │   ├── Line.java
│   │   ├── Rectangle.java
│   │   ├── Circle.java
│   │   └── Donut.java
│   │
│   └── gui/
│       ├── DrawingApp.java
│       ├── FrmDrawing.java
│       ├── PnlDrawing.java
│       │
│       ├── DlgPoint.java
│       ├── DlgLine.java
│       ├── DlgRectangle.java
│       ├── DlgCircle.java
│       └── DlgDonut.java
│
└── README.md
```

The structure above highlights the main Drawing components. The repository also contains the Stack and Sort implementations.

---

## 🚀 Getting Started

### Prerequisites

To run the application, you will need:

- Java Development Kit (JDK)
- A Java-compatible IDE

Recommended IDEs:

- IntelliJ IDEA
- Eclipse
- NetBeans

### Installation

**1. Clone the repository**

Clone the project using GitHub's repository URL:

```bash
git clone <repository-url>
```

**2. Open the project**

Open the cloned project directory in your preferred Java IDE.

**3. Configure the Java SDK**

Make sure a compatible JDK is configured for the project.

**4. Run the Drawing application**

Locate the main application entry point:

```text
gui.DrawingApp
```

Run the class containing the `main()` method.

**5. Explore the additional modules**

The Stack and Sort applications can be launched through their respective entry points.

---

## 🎮 How to Use

### Drawing a Shape

1. Launch the Drawing application.
2. Select a geometric shape from the toolbar.
3. Click on the drawing canvas.
4. Enter additional properties if required.
5. Select the desired colors.
6. Confirm the dialog to create the shape.

### Drawing a Line

Line creation requires two consecutive clicks:

1. Select the Line tool.
2. Click to define the starting point.
3. Click again to define the ending point.
4. The application draws a line between the two coordinates.

### Modifying a Shape

1. Activate selection mode.
2. Click on an existing shape.
3. Select the Modify action.
4. Update the desired properties.
5. Confirm the changes.

The application updates the existing shape and refreshes the canvas.

### Deleting a Shape

1. Activate selection mode.
2. Select a shape.
3. Click Delete.
4. Confirm the deletion.

The selected shape is removed from the canvas.

---

## ⚙️ Technical Implementation

### Graphics Rendering

The drawing canvas is implemented using a custom `JPanel`.

Geometric objects provide their own rendering logic through Java AWT graphics methods.

The panel iterates over the stored shapes and invokes their drawing operations.

After changes to the shape collection or object properties, the application requests a canvas refresh using `repaint()`.

### Shape Management

Geometric objects are stored in a collection that preserves their drawing order.

This allows the application to:

- Iterate through all shapes.
- Render objects in the correct order.
- Identify selected shapes.
- Modify existing objects.
- Remove objects from the drawing.

### Selection and Hit Detection

Shape selection is implemented through mouse interaction and geometric hit detection.

When the user clicks on the canvas, the application checks whether the click coordinates belong to an existing shape.

When shapes overlap, the selection process prioritizes the most recently drawn object.

### Input Dialogs

Each shape type has a dedicated modal dialog for entering and modifying its properties.

The dialogs provide:

- Property input fields
- Validation
- Confirmation and cancellation
- Color selection where applicable

The same dialog class can be reused for both object creation and modification.

---

## 🎓 Academic Context

This project was developed as part of the course:

**Object-Oriented Information Technologies**

Faculty of Technical Sciences  
University of Novi Sad  
Serbia

Academic Year: **2025/2026**

The project focuses on applying object-oriented programming principles to practical desktop application development.

It combines:

- Geometric modeling
- Graphical user interfaces
- Event-driven programming
- Collections and data structures
- Object manipulation
- Input validation
- Sorting algorithms

The project provided practical experience in designing and implementing an interactive Java application using reusable and maintainable object-oriented components.

---

## 👨‍💻 Author

**Petar Popović**

Information Systems Engineering Student  
Faculty of Technical Sciences, University of Novi Sad

- [GitHub](https://github.com/petarpopovic013)
- [LinkedIn](https://www.linkedin.com/in/petarpopovic013/)

---

<p align="center">
  Developed with Java, Swing, and Object-Oriented Programming.
</p>
