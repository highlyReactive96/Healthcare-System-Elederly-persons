

# Elderly Health Care Application

This project aims to help elderly individuals lead healthier and better lives by providing a platform for managing their activities, health records, medications, and more.

## Features

- **Activity Management:** Users can create, track, and manage their activities. The application provides features such as setting reminders, tracking progress, and generating activity reports.

- **Health Record Management:** Users can create, view, and manage their health records. The application allows users to input vital signs, medical history, and other relevant information.

- **Medication Tracking:** Users can track their medications and receive reminders for taking them. The application provides a medication schedule, dosage information, and alerts for missed doses.

- **Appointment Management:** Users can schedule and manage their medical appointments. The application provides reminders, appointment details, and the ability to add notes or attachments.

- **Emergency Contacts:** Users can store emergency contact information within the application. This allows quick access to important contacts during emergencies.

- **Community Forum:** The application includes a community forum where users can interact, share health tips, ask questions, and provide support to each other.

## Backend API

The backend API of the application is implemented using Spring Boot and provides the following endpoints:

### ActivityController

- `POST /users/{userId}/activities`: Create a new activity for a user.
- `GET /users/{userId}/activities`: Get a list of activities for a user.
- `PUT /users/{userId}/activities/{activityId}/enable-reminder`: Enable the reminder for a specific activity.
- `PUT /users/{userId}/activities/{activityId}/disable-reminder`: Disable the reminder for a specific activity.
- `GET /users/{userId}/activities/{activityId}/report`: Generate a report for a specific activity.

### HealthRecordController

- `POST /users/{userId}/health-records`: Create a new health record for a user.
- `GET /users/{userId}/health-records`: Get a list of health records for a user.
- `GET /users/{userId}/health-records/active-medications`: Get a list of active medications for a user.
- `GET /users/{userId}/health-records/vital-signs`: Get a list of vital signs records for a user.

### MedicationController

- `POST /users/{userId}/medications`: Add a new medication for a user.
- `GET /users/{userId}/medications`: Get a list of medications for a user.
- `PUT /users/{userId}/medications/{medicationId}/enable-reminder`: Enable the reminder for a specific medication.
- `PUT /users/{userId}/medications/{medicationId}/disable-reminder`: Disable the reminder for a specific medication.

### AppointmentController

- `POST /users/{userId}/appointments`: Schedule a new appointment for a user.
- `GET /users/{userId}/appointments`: Get a list of appointments for a user.
- `PUT /users/{userId}/appointments/{appointmentId}`: Update an existing appointment for a user.
- `DELETE /users/{userId}/appointments/{appointmentId}`: Delete an appointment for a user.

### UserController

- `POST /users/register`: Register a new user.
- `GET /users/{userId}/health-records`: Get a list of health records for a user.
- `GET /users/{userId}/medications`: Get a list of medications for a user.
- `GET /users/{userId}/appointments`: Get a list of appointments for a user.

**Note:** Replace `{userId}`, `{activityId}`, `{medication

Id}`, and `{appointmentId}` with the appropriate user, activity, medication, and appointment IDs.

## Frontend

The frontend of the application is under development and is not yet completed. However, a basic registration page and dashboard have been implemented for demonstration purposes. The frontend is built using React and communicates with the backend API.

**Please note that the frontend is not fully functional and should be considered as a work in progress.**

## Installation

To run the application, follow these steps:

1. Clone the repository from GitHub: [repository-link](https://github.com/your-username/repository-name)

2. Backend Setup:
   - Configure the necessary database credentials in the `application.properties` file.
   - Build and run the Spring Boot application.

3. Frontend Setup:
   - Navigate to the frontend directory.
   - Install the required dependencies by running `npm install`.
   - Start the frontend application by running `npm start`.

## Use Cases

The following additional use cases have been implemented in the backend part of the application:

4. **Vital Signs Tracking:**
   - Users can input and track their vital signs, such as blood pressure, heart rate, and blood glucose levels, using the `/users/{userId}/health-records/vital-signs` API endpoint.
   - Users can retrieve their vital signs records for monitoring and sharing with healthcare professionals.

5. **Medication Reminders:**
   - Users can add medications using the `/users/{userId}/medications` API endpoint.
   - Medications have reminder features enabled by default to ensure timely dosage administration.
   - Users can enable or disable reminders for specific medications using the `/users/{userId}/medications/{medicationId}/enable-reminder` and `/users/{userId}/medications/{medicationId}/disable-reminder` API endpoints.

6. **Appointment Management:**
   - Users can schedule appointments using the `/users/{userId}/appointments` API endpoint.
   - Users can update or cancel appointments using the `/users/{userId}/appointments/{appointmentId}` API endpoints.
   - The application provides reminders and notifications for upcoming appointments.

Please note that the above use cases are implemented in the backend, and the frontend is a work in progress.

