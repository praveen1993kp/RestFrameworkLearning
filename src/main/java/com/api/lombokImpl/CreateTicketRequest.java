package com.api.lombokImpl;

import lombok.Getter;
import lombok.Setter;

public class CreateTicketRequest {

	Fields fields;	
	
	public Fields getFields() {
		return fields;
	}

	public void setFields(Fields fields) {
		this.fields = fields;
	}
	
	public class Fields{
		private Project project;
		
		private String summary;
		
		private String description;
		
		private IssueType issuetype;
		
		public Project getProject() {
			return project;
		}

		public void setProject(Project project) {
			this.project = project;
		}

		public String getSummary() {
			return summary;
		}

		public void setSummary(String summary) {
			this.summary = summary;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public IssueType getIssuetype() {
			return issuetype;
		}

		public void setIssuetype(IssueType issuetype) {
			this.issuetype = issuetype;
		}	
	}
	
	
	
	public class Project{
		private String key;

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}
	}
	
	public class IssueType{
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}	
	}
}
