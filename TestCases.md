# ShelfGuard — Test Scenarios & Test Cases

Site under test: https://demoqa.com/ (Book Store Application)
Scope: Register → Login → Search Book → Add to Collection → Profile (confirmation)

## Test Scenarios
1. New user registration
2. Duplicate username registration is rejected
3. Login with valid / invalid credentials
4. Book search returns results
5. Add book to personal collection
6. Profile page confirms the book was added

## Test Cases

| TC ID | Title | Steps | Expected Result | Priority |
|-------|-------|-------|-----------------|----------|
| TC_01 | New user registration | 1. Go to /register 2. Fill First Name, Last Name, Username, Password 3. Click Register | Success message: "User Register Successfully" | High |
| TC_02 | Duplicate registration rejected | 1. Register with a username 2. Register again with same username | Error: "User already exists!" | Medium |
| TC_03 | Login with valid credentials | 1. Go to /login 2. Enter registered username/password 3. Click Login | Redirects to Book Store, username visible | High |
| TC_04 | Login with invalid credentials | 1. Enter random username/password 2. Click Login | Error: "Invalid username or password!" | High |
| TC_05 | Search for a book | 1. Go to /books 2. Type keyword in search box | Book list filters to matching results | Medium |
| TC_06 | Open book details | 1. Click a book title from results | Book detail page opens with title, author, publisher | Medium |
| TC_07 | Add book to collection | 1. On book detail page, click "Add To Your Collection" | No error shown, redirects back to book list | High |
| TC_08 | Verify book in profile (confirmation) | 1. Go to /profile after adding book | Added book title appears in the user's book list table | High |
| TC_09 | End-to-end flow (combined) | 1. Register 2. Login 3. Search 4. Add book 5. Check profile | Book appears in profile — full flow completes without errors | High |

