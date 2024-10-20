package com.avi.offlinefirstapp.presentation.ui.screen

import androidx.compose.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.avi.offlinefirstapp.domain.model.User
import com.avi.offlinefirstapp.presentation.viewmodel.UserViewModel

@Composable
fun UserScreen(viewModel: UserViewModel = viewModel()) {
    LaunchedEffect(Unit) {
        viewModel.fetchUsers()
    }

    LazyColumn {
        items(viewModel.users) { user ->
            UserItem(user)
        }
    }
}

@Composable
fun UserItem(user: User) {
    Row(modifier = Modifier.padding(16.dp)) {
        // Load image using Glide
        Image(
            painter = rememberGlidePainter(request = user.imageUrl),
            contentDescription = user.name,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape) // Optional: To make image circular
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = user.name, style = MaterialTheme.typography.h5)
            Text(text = user.email, style = MaterialTheme.typography.h5)
        }
    }
}

