# RecyclerView Drag and Drop

[![Kotlin](https://img.shields.io/badge/Kotlin-100%25-brightgreen.svg)](https://kotlinlang.org/)
[![Medium](https://img.shields.io/badge/Medium-Follow-black.svg)](https://medium.com/@rimshadmohamed)

A demonstration project showcasing how to implement drag and drop functionality in Android's RecyclerView using Kotlin. This repository contains the complete source code for my Medium tutorial article.

## 📝 Tutorial Article

This project is a companion to my tutorial article on Medium. You can read the complete guide here:
[Implementation Guide on Medium](https://medium.com/@rimshadmohamed)

## 🚀 Features

- Complete implementation of drag and drop in RecyclerView
- ItemTouchHelper integration
- Custom animations during drag operations
- Reorderable list items
- Clean Kotlin implementation

## 🛠 Tech Stack

- Kotlin
- Android SDK
- AndroidX RecyclerView
- ItemTouchHelper
- Material Design Components

## 📱 Implementation Highlights

- Custom ItemTouchHelper.Callback
- Drag handle implementation
- Position updating logic
- Smooth animations
- List state preservation

## 🏗 Project Structure

```
app/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── adapter/
│   │   │   │   └── DragDropAdapter.kt
│   │   │   ├── helper/
│   │   │   │   └── ItemTouchHelperCallback.kt
│   │   │   └── MainActivity.kt
│   │   └── res/
│   │       └── layout/
│   │           ├── activity_main.xml
│   │           └── item_draggable.xml
```

## 🚦 Getting Started

1. Clone the repository
```bash
git clone https://github.com/rimshadpcs/RecyclerView-Drag-and-Drop.git
```

2. Open the project in Android Studio

3. Build and run the project on an emulator or physical device

## 📋 Prerequisites

- Android Studio Arctic Fox or later
- Android SDK 21 or above
- Kotlin plugin

## 🤝 Contributing

Contributions, issues, and feature requests are welcome! Feel free to check [issues page](https://github.com/rimshadpcs/RecyclerView-Drag-and-Drop/issues).

## 📝 License

This project is [MIT](LICENSE) licensed.

## ✍️ Author

**Mohamed Rimshad**
- Medium: [@rimshadmohamed](https://medium.com/@rimshadmohamed)
- Github: [@rimshadpcs](https://github.com/rimshadpcs)

## 🙏 Acknowledgments

- Thanks to all the developers who have contributed to making RecyclerView and ItemTouchHelper awesome
- Special thanks to the Android development community

## 📖 Additional Resources

- [Official Android Documentation on RecyclerView](https://developer.android.com/guide/topics/ui/layout/recyclerview)
- [ItemTouchHelper Documentation](https://developer.android.com/reference/androidx/recyclerview/widget/ItemTouchHelper)
