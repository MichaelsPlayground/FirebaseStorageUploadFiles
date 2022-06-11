# Firebase Storage Upload files to the storage

**Upload Image:** https://www.geeksforgeeks.org/android-how-to-upload-an-image-on-firebase-storage/?ref=gcse

The images are stored in the images folder on Storage

**Upload Video:** https://www.geeksforgeeks.org/how-to-upload-a-video-in-firebase-database-using-android-studio/?ref=gcse

The videos are stored in the Files folder on Storage

Stores the upload uri in Firebase Realtime database

**Upload PDFs:** https://www.geeksforgeeks.org/how-to-upload-pdf-files-in-firebase-storage-in-android/?ref=gcse

The PDFs are stored in the root directory on Storage.

**View Images:** https://www.geeksforgeeks.org/how-to-view-all-the-uploaded-images-in-firebase-storage/amp/

Shows the images in the images-Folder in a recyclerview



```plaintext
By default Firebase cloud storage allows only authenticated users to read from and write to it. To authorize a user to allow him to read only his files, first files needs to be saved under a node with node name as user id and then define a security rule to allow users to read files from child nodes of the node that matches to authenticated user id as shown below. You need to add this storage security rule in Firebase console.

 service firebase.storage {
  match /b/{bucket}/o {
    match /user/{userId}/{allPaths=**} {
      allow read, write: if request.auth.uid == userId;
    }
  }
} 
Since we are using Firestore to track uploaded files, we need to define security rules for Firestore also as shown below.

 service cloud.firestore {
  match /databases/{database}/documents {
    match /files/{userId} {
      allow read, write: if request.auth.uid == userId;
    }
  }
} 
```