package com.example.elasticsearch;

import org.apache.http.client.utils.DateUtils;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;

@SpringBootApplication
@RestController
public class ElasticsearchApplication {

	@Autowired
	private TransportClient client;

	public static void main(String[] args) {
		SpringApplication.run(ElasticsearchApplication.class, args);
	}

	@GetMapping("get/book")
	@ResponseBody
	public ResponseEntity get(@RequestParam(name = "id", defaultValue = "") String id) {
		if(StringUtils.isEmpty(id)) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}

		GetResponse response = this.client.prepareGet("books", "book", id).get();
		if(!response.isExists()){
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(response.getSource(), HttpStatus.OK);
	}

	@PostMapping("add/book")
	@ResponseBody
	public ResponseEntity add(
			@RequestParam(name = "title") String title,
			@RequestParam(name = "author") String author,
			@RequestParam(name = "wordcount") int wordcount,
			@RequestParam(name = "publishdate") @DateTimeFormat(pattern = "yyyy-MM-dd")
			Date publishdate
	) {
		try {
			XContentBuilder builder = XContentFactory.jsonBuilder().startObject()
					.field("title", title)
					.field("author", author)
					.field("wordcount", wordcount)
					.field("publishdate", DateUtils.formatDate(publishdate, "yyyy-MM-dd"))
					.endObject();


			IndexResponse response = this.client.prepareIndex("books", "book", "3")
					.setSource(builder).get();

			return new ResponseEntity(response.getId(), HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("delete/book")
	@ResponseBody
	public ResponseEntity delete(@RequestParam(name = "id") String id) {
		DeleteResponse response = this.client.prepareDelete("books", "book", id).get();
		return new ResponseEntity(response.getResult().toString(), HttpStatus.OK);
	}

	@PutMapping("update/book")
	@ResponseBody
	public ResponseEntity update(
			@RequestParam(name = "id") String id,
			@RequestParam(name = "title") String title,
			@RequestParam(name = "author") String author
	){
		UpdateRequest updateRequest = new UpdateRequest("books", "book", id);

		try {
			XContentBuilder xContentBuilder = XContentFactory.jsonBuilder().startObject();
			if
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
